package com.zabara.introweb.repository;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.zabara.introweb.domain.Contact;
import com.zabara.introweb.domain.Task;
import com.zabara.introweb.domain.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Yaroslav_Zabara on 6/4/2014.
 */
public class TestRepositoryImp implements TestRepository {

	private static TestRepositoryImp instance;

	private static List<Test> tests;
	private TaskRepository taskRepository = TaskRepositoryImpl.getInstance();

	static {
		instance = new TestRepositoryImp();
	}

	private TestRepositoryImp() {
		tests = new ArrayList<Test>();
		fillRepo();
	}

	public static TestRepositoryImp getInstance() {
		if (instance == null) {
			instance = new TestRepositoryImp();
		}
		return instance;
	}

	private void fillRepo() {
		Test test = new Test();
		test.setAuthor(new Contact("Yaroslav","123"));
		test.setCreationDate(new Date());
		List<Task> testList = new ArrayList<Task>();
		testList.add(taskRepository.getTaskById(1));
		testList.add(taskRepository.getTaskById(2));
		testList.add(taskRepository.getTaskById(3));
		testList.add(taskRepository.getTaskById(4));
		test.setTasks(testList);
	   	test.setId(new Long(0));
		addTest(test);
	}

	@Override
	public List<Test> getTests() {
		return tests;
	}

	@Override
	public Test getTestById(final Long id) {
		Predicate<Test> filter = new Predicate<Test>() {
			@Override
			public boolean apply(Test task) {
				return task.getId().equals(id);
			}
		};
		return Iterables.find(tests, filter);
	}

	@Override
	public boolean addTest(Test test) {
		if (test.isCorrect()) {
			tests.add(test);
		}
		return false;
	}
}
