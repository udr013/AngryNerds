package eu.programit.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import eu.programit.domain.Answer;
import eu.programit.domain.Question;
import eu.programit.repository.AnswerRepository;

@Service
public class AnswerService implements IAnswerService {

//    @Autowired
    AnswerRepository answerRepository;

    @Override
    public Collection<Answer> findAllByQuestion(Question question) {
        Iterable<Answer> itr = answerRepository.findAllByQuestion(question);
        return (Collection<Answer>) itr ;
    }
}
