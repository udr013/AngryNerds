package eu.programit.repository;

import eu.programit.domain.TestResult;
import eu.programit.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TestResultRepository extends CrudRepository<TestResult, Integer>{

	TestResult save(TestResult testResult);
	Iterable<TestResult> findByUser(User user);

}
