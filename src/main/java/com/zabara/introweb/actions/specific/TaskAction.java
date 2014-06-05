package com.zabara.introweb.actions.specific;

import com.google.common.collect.ImmutableList;
import com.zabara.introweb.Utils;
import com.zabara.introweb.actions.Action;
import com.zabara.introweb.actions.ActionException;
import com.zabara.introweb.domain.Contact;
import com.zabara.introweb.domain.Task;
import com.zabara.introweb.repository.TaskRepository;
import com.zabara.introweb.repository.TaskRepositoryImpl;
import com.zabara.introweb.views.View;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Yaroslav on 02.06.2014.
 */
public class TaskAction implements Action {

    private static final Logger logger = Logger.getLogger(TaskAction.class.getName());
	private Task task = new Task();
	private  List<String> errors = new ArrayList<String>();
	private TaskRepository taskRepository = TaskRepositoryImpl.getInstance();

    @Override
    public void execute(View view) {
		task = new Task();
		errors.clear();
		if ("GET".equals(view.getRequest().getMethod())){
			String id = view.getRequest().getParameter("id");
			try {
				Long longId = Long.parseLong(id);
				Task task = taskRepository.getTaskById(longId);
				if (task != null) {
					view.getRequest().setAttribute("task", task);
				} else {
					errors.add("Can't find task with id = " + id);
				}
			} catch (Exception ex){
				errors.add("Can't get task with id = " + id);
				logger.log(Level.SEVERE, "Can't get task with id = " + id + " " + ex.getMessage());
			}
			return;
		}
		int taskId = -1;
		try {
			taskId = Integer.parseInt(view.getRequest().getParameter("id"));
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}

		if (taskId > -1) {
			editTask(view);
		} else {
			addNewTask(view);
		}


    }

	private void editTask(View view) {
		fillTask(view);
		task.setId(Long.parseLong(view.getRequest().getParameter("id")));
		try{
			if (errors.size() > 0 || !task.isCorrectTask()) {
				view.getRequest().setAttribute("errors", errors);
			} else {
				view.getRequest().setAttribute("success", ImmutableList.of("Task was changed"));
				view.getRequest().setAttribute("task", task);
				if(!taskRepository.editTask(task)){
					view.getRequest().setAttribute("errors", ImmutableList.of("Task wasn't changed"));
				}
			}
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}
	}

	private void addNewTask(View view) {

		//TODO сделать норм ид
		task.setId((long) Utils.randInt(0, 100000));
		fillTask(view);
		try{
			if (errors.size() > 0 || !task.isCorrectTask()) {
				view.getRequest().setAttribute("errors", errors);
			} else {
				view.getRequest().setAttribute("success", ImmutableList.of("Task was added"));
				view.getRequest().setAttribute("task", task);
				if(!taskRepository.addTask(task)){
					view.getRequest().setAttribute("errors", ImmutableList.of("Task wasn't added"));
				}
			}
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}
	}

	private void fillTask(View view) {
		int variantsSize = 0;
		String question = "";
		int answerNumber = -1;
		List<String> variants = new ArrayList<String>();
		long id = -1;
		try {
			question = view.getRequest().getParameter("question");
			if (question == null || question.isEmpty()) {
				errors.add("question is empty");
			}
			variantsSize = Integer.parseInt(view.getRequest().getParameter("variantsSize"));
		} catch (Exception ex) {
			errors.add(ex.getMessage());
			logger.log(Level.SEVERE, ex.getMessage());
		}

		try {
			id = Long.parseLong(view.getRequest().getParameter("id"));
		} catch (Exception ex) {
			errors.add(ex.getMessage());
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
			answerNumber = Integer.parseInt(view.getRequest().getParameter("options"+id));
			if (answerNumber > variants.size() || answerNumber < 0 ) {
				errors.add("Answer number is incorrect");
			}
			task.setAnswerIndex(answerNumber);
		} catch (Exception ex) {
			errors.add("Answer number is empty");
			logger.log(Level.SEVERE, ex.getMessage());
		}

		task.setQuestion(question);
		task.setAnswerIndex(answerNumber);
		task.setVariants(variants);
		task.setId(id);
		//TODO сделать проверку на создателя
		task.setOwner(new Contact("Slava","123"));
	}
}
