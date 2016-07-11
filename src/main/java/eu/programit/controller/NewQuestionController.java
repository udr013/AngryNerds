package eu.programit.controller;

import eu.programit.domain.Answer;
import eu.programit.domain.Question;
import eu.programit.service.IAnswerService;
import eu.programit.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class NewQuestionController {
	private String toTheAnswersPage = "answers";

    @Autowired
    IQuestionService iQuestionService;

    @Autowired
    IAnswerService iAnswerService;

    @RequestMapping(value = "/questionsave", method = RequestMethod.POST)
    public String saveQuestion(@ModelAttribute("question") Question question, Model model) {
        System.out.println(question);
        iQuestionService.saveQuestion(question);
        model.addAttribute("answer", new Answer());
        return toTheAnswersPage;
    }

    @RequestMapping(value = "/answersave", method = RequestMethod.POST)
    public String saveAnswer(@ModelAttribute("answer") Answer answer, Model model) {
        List<Question> questions = (List<Question> )iQuestionService.findAll();
        Question addedQuestion = questions.get(questions.size()-1);
        answer.setQuestion(addedQuestion);
        System.out.println(answer);
        iAnswerService.saveAnswer(answer);
        List<Answer> answers = addedQuestion.getAnswers();
        model.addAttribute("question", addedQuestion);//the 1 will get question 2 (index 0)
        model.addAttribute("answer", new Answer());
        model.addAttribute("answers", answers);

        return toTheAnswersPage ;
    }

}
