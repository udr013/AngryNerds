package eu.programit.service;

import eu.programit.domain.TestContent;
import org.springframework.beans.factory.annotation.Autowired;

import eu.programit.repository.TestContentRepository;

public class TestContentService {
	@Autowired
	private TestContentRepository testContentRepository;
	
	//@Override
	public TestContent findById(int testId){
		return testContentRepository.findOne(testId);
	}
	
	//@Override
	public Iterable<TestContent> findAll() {
		return testContentRepository.findAll();
	}

//	@Override
	public TestContent saveTestContent(TestContent testContent){
		return testContentRepository.save(testContent);

	}

}
