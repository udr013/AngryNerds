package eu.programit.service;

import java.util.Collection;

import eu.programit.domain.Answer;
import eu.programit.domain.Question;

public interface IAnswerService {
    Collection<Answer> findAllByQuestion(Question question);
}
