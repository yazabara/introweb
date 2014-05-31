package com.zabara.introweb.actions.specific;

import com.zabara.introweb.actions.Action;
import com.zabara.introweb.repository.TaskRepository;
import com.zabara.introweb.repository.TaskRepositoryImpl;
import com.zabara.introweb.views.View;

/**
 * Created by Yaroslav on 31.05.2014.
 */
public class QuestionsAction implements Action{

    TaskRepository taskRepository = TaskRepositoryImpl.getInstance();


    @Override
    public void execute(View view) {
        view.getRequest().setAttribute("questionList", taskRepository.getTasks());
    }
}
