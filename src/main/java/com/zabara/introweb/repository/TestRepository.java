package com.zabara.introweb.repository;

import com.zabara.introweb.domain.Test;

import java.util.List;

/**
 * Created by Yaroslav_Zabara on 6/4/2014.
 */
public interface TestRepository {

	List<Test> getTests();

	Test getTestById(Long id);

	boolean addTest(Test test);
}
