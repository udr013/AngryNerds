package eu.programit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.programit.domain.Answer;
import eu.programit.domain.Question;
import eu.programit.service.AnswerService;
import eu.programit.service.QuestionService;

@Controller
public class NewQuestionController {


    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @RequestMapping(value = "/questionsave", method = RequestMethod.POST)
    public String saveQuestion(@ModelAttribute("question") Question question, Model model) {
        System.out.println(question);
        questionService.saveQuestion(question);
        model.addAttribute("answer", new Answer());
        return "answers";
    }

    @RequestMapping(value = "/answersave", method = RequestMethod.POST)
    public String saveAnswer(@ModelAttribute("answer") Answer answer, Model model) {
        List<Question> questions = (List<Question> )questionService.findAll();
        Question addedQuestion = questions.get(questions.size()-1);
        answer.setQuestion(addedQuestion);
        System.out.println(answer);
        answerService.saveAnswer(answer);
        List<Answer> answers = addedQuestion.getAnswers();
        model.addAttribute("question", addedQuestion);//the 1 will get question 2 (index 0)
        model.addAttribute("answer", new Answer());
        model.addAttribute("answers", answers);

        return "answers" ;
    }

}
