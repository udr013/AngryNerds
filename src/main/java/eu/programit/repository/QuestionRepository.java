package eu.programit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import eu.programit.domain.Question;

@Component
public interface QuestionRepository extends CrudRepository<Question, Long> { 
	
}

