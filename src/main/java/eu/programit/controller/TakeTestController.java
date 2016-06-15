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

@Controller
public class TakeTestController {

	int questionCounter;
	
	@Autowired
	IQuestionService iQuestionService;
	
	@Autowired
	IAnswerService iAnswerService;
	
    @RequestMapping(value = "/loadExamQuestion", method = RequestMethod.GET)
    public String start(Model model) {
        List<Question>questions = (List<Question>)iQuestionService.findAll();
        model.addAttribute("question", questions.get(questionCounter));//the 1 will get question 2 (index 0)
        questionCounter++;
        List<Answer>answers =(List<Answer>) iAnswerService.findAllByQuestion(questions.get(0));
        model.addAttribute("answers", answers);
        //model.addAttribute("selectedAnswers", selectedAnswers);
        return "examquestion";
    }
}
