package eu.programit.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.programit.domain.Question;
import eu.programit.repository.QuestionRepository;

@Service
@Transactional
public class QuestionService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QuestionService.class);
	
	@Autowired
	private QuestionRepository questionRepository;

	


	public Iterable<Question> findAll() {
		Iterable<Question> result = this.questionRepository.findAll();
		
		LOGGER.info("The result of all questions are [{}]", result);

		return result;
	}


	public Question saveQuestion(Question question) {
		return questionRepository.save(question);
	}


	public Question findById(int questionID) {
		
		return questionRepository.findOne(questionID);
	}
}
