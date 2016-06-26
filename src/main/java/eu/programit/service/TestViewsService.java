package eu.programit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.programit.domain.TestViews;
import eu.programit.repository.TestViewsRepository;


@Service
@Transactional
public class TestViewsService implements ITestViewsService {
	
	@Autowired
	private TestViewsRepository testViewsRepository;
	
	@Override
	public TestViews findById(int testviewId){
		return testViewsRepository.findOne(testviewId);
	}
	
	@Override
	public Iterable<TestViews> findAll() {
		return testViewsRepository.findAll();
	}

	@Override
	public TestViews saveTestViews(TestViews testViews){
		return testViewsRepository.save(testViews);

	}

}
