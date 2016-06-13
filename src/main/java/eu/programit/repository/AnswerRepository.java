package eu.programit.repository;

import eu.programit.domain.Answer;
import eu.programit.domain.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by udr013 on 13-6-2016.
 */
@Component
public interface AnswerRepository extends CrudRepository<Answer,Integer> {

    List<Answer> findAllByQuestion(Question id);
}
