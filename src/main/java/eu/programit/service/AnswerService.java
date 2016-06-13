package eu.programit.service;

import eu.programit.domain.Answer;
import eu.programit.domain.Question;
import eu.programit.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by udr013 on 13-6-2016.
 */
@Service
public class AnswerService implements IAnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public List<Answer> findAllByQuestion(Question question) {
        Iterable<Answer> itr = answerRepository.findAllByQuestion(question);
        return (List<Answer>) itr ;
    }
}
