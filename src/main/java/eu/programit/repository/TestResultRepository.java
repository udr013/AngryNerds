package eu.programit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import eu.programit.domain.TestResults;
import eu.programit.domain.User;

@Component
public interface TestResultRepository extends CrudRepository<TestResults, Integer>{

	Iterable<TestResults> findByUser(User user);

}
