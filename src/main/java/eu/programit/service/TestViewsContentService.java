package eu.programit.service;

import org.springframework.beans.factory.annotation.Autowired;

import eu.programit.domain.TestViewsContent;
import eu.programit.repository.TestViewsContentRepository;

public class TestViewsContentService {
	@Autowired
	private TestViewsContentRepository testViewsContentRepository;
	
	//@Override
	public TestViewsContent findById(int testviewId){
		return testViewsContentRepository.findOne(testviewId);
	}
	
	//@Override
	public Iterable<TestViewsContent> findAll() {
		return testViewsContentRepository.findAll();
	}

//	@Override
	public TestViewsContent saveTestViews(TestViewsContent testViews){
		return testViewsContentRepository.save(testViews);

	}

}
