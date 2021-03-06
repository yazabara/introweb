package com.zabara.introweb.repository;

import com.zabara.introweb.domain.Contact;
import com.zabara.introweb.domain.Task;

import java.util.List;

/**
 * Created by Yaroslav_Zabara on 5/30/2014.
 */
public interface TaskRepository {

    List<Task> getTasks();

    boolean addTask(Task task);

	/**
	 * изменение таска - по id.
	 * Остальные поля проверяются на пустоту - если не пустые - меняются.
	 *
	 * @param task
	 * @return удалось ли изменить
	 */
	boolean editTask(Task task);

    Task getTaskById(long id);

    List<Task> getTasksByOwner(Contact owner);
}
