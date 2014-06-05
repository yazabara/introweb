package com.zabara.introweb.actions.specific;

import com.zabara.introweb.actions.Action;
import com.zabara.introweb.repository.TaskRepository;
import com.zabara.introweb.repository.TaskRepositoryImpl;
import com.zabara.introweb.repository.TestRepository;
import com.zabara.introweb.repository.TestRepositoryImp;
import com.zabara.introweb.views.View;

/**
 * Created by Yaroslav_Zabara on 6/4/2014.
 */
public class TestAction implements Action{

	TestRepository taskRepository = TestRepositoryImp.getInstance();


	@Override
	public void execute(View view) {
		view.getRequest().setAttribute("test", taskRepository.getTestById(new Long(0)));
	}
}
