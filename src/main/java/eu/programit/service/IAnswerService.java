package eu.programit.service;

import eu.programit.domain.Answer;
import eu.programit.domain.Question;

public interface IAnswerService {
    Iterable<Answer> findAllByQuestion(Question question);
}
