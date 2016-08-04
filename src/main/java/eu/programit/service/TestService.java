package eu.programit.service;

import eu.programit.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.programit.repository.TestRepository;


@Service
@Transactional
public class TestService implements ITestService {
	
	@Autowired
	private TestRepository testRepository;
	
	@Override
	public Test findById(int testId){
		return testRepository.findOne(testId);
	}
	
	@Override
	public Iterable<Test> findAll() {
		return testRepository.findAll();
	}

	@Override
	public Test saveTestViews(Test test){
		return testRepository.save(test);

	}

}
