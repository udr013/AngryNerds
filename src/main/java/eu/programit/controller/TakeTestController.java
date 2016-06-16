package eu.programit.controller;

import java.util.List;
import eu.programit.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.programit.domain.Answer;
import eu.programit.domain.Question;
import eu.programit.domain.TestAnswerForm;

@Controller
public class TakeTestController {

	int questionCounter = 1;
	
	@Autowired
	IQuestionService iQuestionService;
	
	@Autowired
	IAnswerService iAnswerService;
	
    @RequestMapping(value = "/loadExamQuestion", method = RequestMethod.GET)
    public String start(Model model, TestAnswerForm testAnswerForm) {
        //List<Question>questions = (List<Question>)iQuestionService.findAll();
    	//model.addAttribute("question", questions.get(questionCounter));//the 1 will get question 2 (index 0)
    	Question q;
    	List<Answer> answers = null;
    	try {
    		q = iQuestionService.findById(questionCounter);
        	answers = q.getAnswers();
    	} catch (NullPointerException npe) {
    		q = new Question();
    		q.setContent("Unknown question requested (questionID does not exist)");
    	}
    	questionCounter++;
        //System.out.println("TakeTestCont: questionCounter = " + questionCounter);
    	model.addAttribute("question", q);//the 1 will get question 2 (index 0)
        
        model.addAttribute("answers", answers);
        
    	//model.addAttribute("selectedAnswers", selectedAnswers);
 
    	return "examquestion";
    }
    
    @RequestMapping(value = "/loadExamQuestion", method = RequestMethod.POST)
    public String getAnswers(TestAnswerForm testAnswerForm) {
    	List<Integer> answ = testAnswerForm.getTestAnswers();
		if (answ != null) {
			for (int s : answ) {
				System.out.println("Answer = " + s);
			}
		}
    	return "redirect:/loadExamQuestion";
    	
    }
}
