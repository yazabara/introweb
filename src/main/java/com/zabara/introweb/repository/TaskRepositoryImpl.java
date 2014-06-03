package com.zabara.introweb.repository;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.zabara.introweb.domain.Contact;
import com.zabara.introweb.domain.Task;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav_Zabara on 5/30/2014.
 */
public class TaskRepositoryImpl implements TaskRepository {

	private static TaskRepositoryImpl instance;

	private static List<Task> tasks;

	static {
		instance = new TaskRepositoryImpl();
	}

	private TaskRepositoryImpl() {
		tasks = new ArrayList<Task>();
		fillRepo();
	}

	private void fillRepo() {
		Contact owner = new Contact("Yaroslav", "123");
		tasks.add(new Task(1, "What is your name?", ImmutableList.of("Yaroslav", "Zabara", "Ilya"), 0, owner));
		tasks.add(new Task(2, "What is your age?", ImmutableList.of("24", "23", "22", "21", "20"), 0, owner));
		tasks.add(new Task(3, "What is your second name?", ImmutableList.of("Arabaz", "Cobra", "Zabara"), 2, owner));
		tasks.add(new Task(4, "What is your name(2)?", ImmutableList.of("Yaroslav(2)", "Zabara(2)", "Ilya(2)"), 1, owner));
	}

	public static TaskRepositoryImpl getInstance() {
		if (instance == null) {
			instance = new TaskRepositoryImpl();
		}
		return instance;
	}

	@Override
	public List<Task> getTasks() {
		return tasks;
	}

	@Override
	public boolean addTask(Task task) {
		if (task != null && task.isCorrectTask()) {
			tasks.add(task);
			return true;
		}
		return false;
	}

	@Override
	public boolean editTask(Task task) {
		if (task == null || task.getId() == null) {
			return false;
		}

		Task taskChanged = getTaskById(task.getId());

		if (taskChanged == null) {
			return false;
		}

		if (task.getOwner() != null && task.getOwner().isCorrect()) {
			taskChanged.setOwner(task.getOwner());
		}

		if (task.getQuestion() != null && !task.getQuestion().isEmpty()) {
			taskChanged.setQuestion(task.getQuestion());
		}

		if (task.getVariants() != null && task.getVariants().size() > 1) {
			List<String> variants = new ArrayList<String>();
			for (String taskStr : task.getVariants()) {
				if (taskStr != null && !taskStr.isEmpty()) {
					variants.add(taskStr);
				}
			}
			if (variants.size() > 1) {
				taskChanged.setVariants(variants);
			}
		}

		if (task.getAnswerIndex() != null && task.getAnswerIndex() >= 0 && task.getAnswerIndex() < taskChanged.getVariants().size()) {
		 	taskChanged.setAnswerIndex(task.getAnswerIndex());
		}

//		simple change
//		tasks.remove(task);
//		tasks.add(taskChanged);

		return true;
	}

	@Override
	public Task getTaskById(final long id) {
		Predicate<Task> filter = new Predicate<Task>() {
			@Override
			public boolean apply(Task task) {
				return task.getId() == id;
			}
		};

		return Iterables.find(tasks, filter);
	}

	@Override
	public List<Task> getTasksByOwner(final Contact owner) {
		Predicate<Task> filter = new Predicate<Task>() {
			@Override
			public boolean apply(Task task) {
				return task.getOwner().getFirstName().equals(owner);
			}
		};

		return (List<Task>) Iterables.filter(tasks, filter);
	}
}
