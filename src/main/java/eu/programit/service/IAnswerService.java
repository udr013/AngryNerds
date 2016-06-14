package eu.programit.service;

import eu.programit.domain.Answer;
import eu.programit.domain.Question;

import java.util.Collection;

public interface IAnswerService {
    Collection<Answer> findAllByQuestion(Question question);
}
