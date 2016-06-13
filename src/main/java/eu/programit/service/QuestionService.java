package eu.programit.service;

import eu.programit.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by udr013 on 9-6-2016.
 */
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    
}
