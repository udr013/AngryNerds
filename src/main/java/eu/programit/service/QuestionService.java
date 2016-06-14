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

	
//	public Question save(Question question) {
//
//		LOGGER.debug("it rocks");
//
//		// aanroep van het door Mockito gemaakte contract (normaliter zet je dat natuurlijk hier
////		niet in de code
//		Question result = this.questionRepository.save(question);
//
//		return result;
//
//	}

	public Iterable<Question> findAll() {
		Iterable<Question> result = this.questionRepository.findAll();

		return result;
	}

	


}
