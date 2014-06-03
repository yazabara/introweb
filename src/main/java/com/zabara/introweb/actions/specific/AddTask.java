package com.zabara.introweb.actions.specific;

import com.google.common.collect.ImmutableList;
import com.zabara.introweb.actions.Action;
import com.zabara.introweb.actions.ActionException;
import com.zabara.introweb.domain.Contact;
import com.zabara.introweb.domain.Task;
import com.zabara.introweb.repository.TaskRepositoryImpl;
import com.zabara.introweb.views.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Yaroslav on 02.06.2014.
 */
public class AddTask implements Action {

    private static final Logger logger = Logger.getLogger(AddTask.class.getName());
	private Task task = new Task();
	private  List<String> errors = new ArrayList<String>();

    @Override
    public void execute(View view) {
		if ("GET".equals(view.getRequest().getMethod())){
			return;
		}
		int taskId = -1;
		try {
			taskId = Integer.parseInt(view.getRequest().getParameter("id"));
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}

		if (taskId > -1) {
			editTask();
		} else {
			addNewTask(view);
		}


    }

	private void editTask() {
		logger.log(Level.SEVERE, "task was eddited");
	}

	private void addNewTask(View view) {
		int variantsSize = 0;
		String question = "";
		int answerNumber = -1;
		List<String> variants = new ArrayList<String>();
		try {
			question = view.getRequest().getParameter("question");
			variantsSize = Integer.parseInt(view.getRequest().getParameter("variantsSize"));
		} catch (Exception ex) {
			errors.add(ex.getMessage());
			logger.log(Level.SEVERE, ex.getMessage());
		}

		if (variantsSize > 0) {
			for (int i = 0; i < variantsSize; i++) {
				try {
					String variant = view.getRequest().getParameter("variant" + i);
					if (variant.isEmpty())
						throw new ActionException("Answer variant is empty");
					variants.add(variant);
				} catch (Exception ex) {
					errors.add("I can't get variant №" + i);
					logger.log(Level.SEVERE, ex.getMessage());
				}
			}
		}

		try {
			answerNumber = Integer.parseInt(view.getRequest().getParameter("rightAnswer"));
		} catch (Exception ex) {
			errors.add(ex.getMessage());
			logger.log(Level.SEVERE, ex.getMessage());
		}

//        TODO сделать норм ид
		task.setId(new Random(new Date().getTime()).nextLong());
		task.setQuestion(question);
		task.setAnswerIndex(answerNumber);
		task.setVariants(variants);
		//TODO сделать проверку на создателя
		task.setOwner(new Contact("Slava","123"));

		try{
			if (errors.size() > 0 || !task.isCorrectTask()) {
				view.getRequest().setAttribute("errors", errors);
			} else {
				view.getRequest().setAttribute("success", ImmutableList.of("Task was added"));
				view.getRequest().setAttribute("task", task);
				if(TaskRepositoryImpl.getInstance().addTask(task)){
					view.getRequest().setAttribute("errors", ImmutableList.of("Task wasn't added"));
				}
			}
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}
	}
}
