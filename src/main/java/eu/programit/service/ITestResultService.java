package eu.programit.service;

import eu.programit.domain.TestResult;
import eu.programit.domain.User;

public interface ITestResultService {
	    TestResult saveTestResult(TestResult testResult);
	    Iterable<TestResult> findAll();
	 //   Iterable<Answer> findAllByQuestion(Question question);
	    TestResult findById(int examID);
		Iterable<TestResult> findByUser(User user);
	}


