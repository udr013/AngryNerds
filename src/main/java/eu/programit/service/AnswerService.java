package eu.programit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.programit.domain.Answer;
import eu.programit.domain.Question;
import eu.programit.repository.AnswerRepository;

@Service
public class AnswerService implements IAnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public Iterable<Answer> findAllByQuestion(Question question) {
        Iterable<Answer> itr = answerRepository.findAllByQuestion(question);

        return itr ;
    }
}
