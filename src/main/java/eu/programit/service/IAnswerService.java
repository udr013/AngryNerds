package eu.programit.service;

import eu.programit.domain.Answer;
import eu.programit.domain.Question;

import java.util.List;

/**
 * Created by udr013 on 13-6-2016.
 */
public interface IAnswerService {
    List<Answer> findAllByQuestion(Question question);
}
