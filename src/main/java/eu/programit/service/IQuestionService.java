package eu.programit.service;

import eu.programit.domain.Question;

public interface IQuestionService{

    Question saveQuestion(Question question);
    Iterable<Question> findAll();
    
    Question findById(int questionID);


}
