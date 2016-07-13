package eu.programit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import eu.programit.domain.TestResults;
import eu.programit.domain.TestViewsContent;

@Component
public interface TestViewsContentRepository extends CrudRepository<TestViewsContent, Integer>{
	TestViewsContent save(TestViewsContent testViewsContent);

}
