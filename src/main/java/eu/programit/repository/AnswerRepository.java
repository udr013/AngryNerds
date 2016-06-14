package eu.programit.repository;

import eu.programit.domain.Answer;
import eu.programit.domain.Question;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;



@Component
public interface AnswerRepository extends CrudRepository<Answer,Integer> {
	
	//Not yet obsolete because is has been replaced by Question.answers
    Collection<Answer> findAllByQuestion(Question id);
}
