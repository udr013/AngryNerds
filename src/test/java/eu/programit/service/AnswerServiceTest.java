package eu.programit.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import eu.programit.domain.Answer;
import eu.programit.domain.Question;
import eu.programit.repository.AnswerRepository;

@RunWith(MockitoJUnitRunner.class)
public class AnswerServiceTest {
	
	@InjectMocks
	private AnswerService answerService;
	
	@Mock
	private AnswerRepository answerRepository;
	
	@Test
	public void testFindAll() {
		
		//mock
		Question questionMock = new Question();
		questionMock.setCode("public static void main");
		Answer answerMock = new Answer();
		answerMock.setAnswer("it rocks");
		List<Answer> answersMock = new ArrayList<>();
		answersMock.add(answerMock);
		Mockito.when(this.answerRepository.findAllByQuestion(questionMock)).thenReturn(answersMock);
		
		// service
		Question q = new Question();
		Iterable<Answer> result = this.answerService.findAllByQuestion(q);
		
		for(Answer a : result) {
			Assert.assertEquals("it rocks", a.getAnswer());
		}
	}
	
	
	

}
