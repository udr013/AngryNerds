package eu.programit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import eu.programit.domain.Test;

@Component
public interface TestRepository extends CrudRepository<Test, Integer> {
	
}