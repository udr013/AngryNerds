package eu.programit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.programit.domain.TestViews;
import eu.programit.repository.TestViewsRepository;


@Service
@Transactional
public class TestViewsService {
	
	@Autowired
	private TestViewsRepository testViewsRepository;
	
	public TestViews findById(int testviewId){
		return testViewsRepository.findOne(testviewId);
	}

}
