package eu.programit.controller;


import eu.programit.domain.Answer;
import eu.programit.domain.Question;
import eu.programit.service.IAnswerService;
import eu.programit.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {


    @Autowired
    IQuestionService iQuestionService;
    
    @Autowired
    IAnswerService iAnswerService;
    @RequestMapping("/")
    public String start(){
        return "index";
    }

    @RequestMapping("/exam")
    public String showExam(){
        return "exam";
    }

    @RequestMapping("/vraag")
    public String createQuestion(Model model){
        model.addAttribute("question", new Question());
        return "vraag";
    }
    @RequestMapping(value = "/questionsave", method = RequestMethod.POST)
    public String saveQuestion(@ModelAttribute("question") Question question, Model model) {
        System.out.println(question);
        iQuestionService.saveQuestion(question);
        model.addAttribute("question",question);
        model.addAttribute("answer", new Answer());
        return "answers";
    }

    @RequestMapping(value = "/answersave", method = RequestMethod.POST)
    public String saveQuestion(@ModelAttribute("answer") Answer answer) {
        System.out.println(answer);
        iAnswerService.saveAnswer(answer);

        return "redirect:/answers" ;
    }



    @RequestMapping(value = "/loadExamQuestion", method = RequestMethod.GET)
    public String start(Model model) {
        List<Question>questions = (List<Question>)iQuestionService.findAll();
        model.addAttribute("question", questions.get(0));//the 1 will get question 2 (index 0)
        Iterable<Answer>answers = iAnswerService.findAllByQuestion(questions.get(0));
        model.addAttribute("answers", answers);
        //model.addAttribute("selectedAnswers", selectedAnswers);
        return "examquestion";
    }



    @RequestMapping(value = "/registerQuestion", method = RequestMethod.POST)
    String saveQuestion(Model model, @ModelAttribute("answers") ArrayList<Answer> answers){
        for(Answer x:answers) {
            System.out.println(x);
        }
        return "redirect:/loadExamQuestion";
    }


    @Autowired
    private ErrorAttributes errorAttributes;

    @Bean
    public AppErrorController appErrorController(){return new AppErrorController(errorAttributes);}


}

