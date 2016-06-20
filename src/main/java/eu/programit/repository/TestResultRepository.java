package eu.programit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import junit.framework.TestResult;

@Component
public interface TestResultRepository extends CrudRepository<TestResult, Integer>{

}
