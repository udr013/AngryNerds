package eu.programit.service;

import eu.programit.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.programit.domain.TestResults;
import eu.programit.repository.TestResultRepository;

@Service
public class TestResultService {
	
	@Autowired
	private TestResultRepository testResultRepository;

	public TestResults saveTestResult(TestResults testResult) {
		return testResultRepository.save(testResult);
	}

	
	public Iterable<TestResults> findAll() {
		return this.testResultRepository.findAll();
	}

	public TestResults findById(int examID) {
		
		return this.testResultRepository.findOne(examID);
	}

	public Iterable<TestResults> findByUser(User user) {
		return testResultRepository.findByUser(user);
	}
}
