package com.zabara.introweb.repository;

import com.zabara.introweb.domain.Task;

import java.util.List;

/**
 * Created by Yaroslav_Zabara on 5/30/2014.
 */
public interface TaskRepository {

	List<Task> getTasks();
}
