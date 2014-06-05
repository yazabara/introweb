package com.zabara.introweb.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Yaroslav_Zabara on 6/4/2014.
 */
public class Test implements Serializable {

	private Long id;
	private List<Task> tasks;
	private Contact author;
	private Date creationDate;

	public Test() {
	}

	public Test(Long id, List<Task> tasks, Contact author, Date creationDate) {
		this.id = id;
		this.tasks = tasks;
		this.author = author;
		this.creationDate = creationDate;
	}

	public boolean isCorrect(){
		if (id == null && tasks == null || tasks.size() < 1 || author == null || !author.isCorrect() || creationDate == null) {
			return false;
		}
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Contact getAuthor() {
		return author;
	}

	public void setAuthor(Contact author) {
		this.author = author;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
