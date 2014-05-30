package com.zabara.introweb.repository;

import junit.framework.Assert;
import org.junit.Test;

public class TaskRepositoryImplTest extends Assert {

	@Test
	public void testConnection() throws Exception {
		TaskRepositoryImpl taskRepositoryImpl = new TaskRepositoryImpl();
		taskRepositoryImpl.getConnection();
	}

	@Test
	public void test1() throws Exception {
		TaskRepositoryImpl taskRepositoryImpl = new TaskRepositoryImpl();
		taskRepositoryImpl.getConnection().close();
		taskRepositoryImpl.getConnection().getMetaData();

	}

	public void test2() throws Exception {
		String name = "D:\\Dropbox\\Programming\\java\\introweb\\src\\main\\resources\\scripts\\test.sql";
		TaskRepositoryImpl taskRepositoryImpl = new TaskRepositoryImpl();
		taskRepositoryImpl.runScript(name);
	}
}