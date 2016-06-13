package eu.programit.service;

import eu.programit.domain.Answer;
import eu.programit.domain.Question;
import eu.programit.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by udr013 on 13-6-2016.
 */
@Service
public class AnswerService implements IAnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public Collection<Answer> findAllByQuestion(Question question) {
        Iterable<Answer> itr = answerRepository.findAllByQuestion(question);
        return (Collection<Answer>) itr ;
    }
}
