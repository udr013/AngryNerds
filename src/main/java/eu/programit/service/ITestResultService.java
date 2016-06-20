package eu.programit.service;

import junit.framework.TestResult;


	public interface ITestResultService {
	    TestResult saveTestResult(TestResult testResult);
	    Iterable<TestResult> findAll();
	 //   Iterable<Answer> findAllByQuestion(Question question);
		TestResult findById(int examID);
	}


