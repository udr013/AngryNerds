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
public class QuestionService implements IQuestionService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QuestionService.class);
	
	@Autowired
	private QuestionRepository questionRepository;

	


	public Iterable<Question> findAll() {
		Iterable<Question> result = this.questionRepository.findAll();

		return result;
	}


	@Override
	public Question saveQuestion(Question question) {
		return questionRepository.save(question);
	}


	@Override
	public Question findById(int questionID) {
		// TODO Auto-generated method stub
		return questionRepository.findOne(questionID);
	}
}
