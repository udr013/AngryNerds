package eu.programit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import eu.programit.domain.TestContent;

@Component
public interface TestContentRepository extends CrudRepository<TestContent, Integer>{
	TestContent save(TestContent testContent);

}
