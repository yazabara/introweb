package com.zabara.introweb.repository;

import com.zabara.introweb.domain.Task;


import java.util.List;

/**
 * Created by Yaroslav_Zabara on 5/30/2014.
 */
public class TaskRepositoryImpl extends AbstractRepository implements TaskRepository {

	TaskRepositoryImpl() throws ClassNotFoundException {
		super();
	}

	@Override
	public List<Task> getTasks() {
		return null;
	}
}
