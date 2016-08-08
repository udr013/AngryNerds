package eu.programit.controller;


import eu.programit.domain.Answer;
import eu.programit.domain.Category;
import eu.programit.domain.Question;
import eu.programit.domain.Test;
import eu.programit.service.IAnswerService;
import eu.programit.service.ICategoryService;
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

@Controller
public class WebController {

    @Autowired
    ICategoryService iCategoryService;

    @Autowired
    IQuestionService iQuestionService;
    
    @Autowired
    IAnswerService iAnswerService;

    @RequestMapping("/")
    public String start(){
        return "login";
    }

    @RequestMapping("/login")
    public String login (){
        return "login";
    }

    @RequestMapping("/index")
    public String index (){
        return "index";
    }

    @RequestMapping("/vraag")
    public String createQuestion(Model model){
        model.addAttribute("question", new Question());
        model.addAttribute("categories", iCategoryService.findAll());
        return "vraag";
    }

    @RequestMapping("/createexam")
    public String createExam(Model model) {
        model.addAttribute("test", new Test());

        return "addExam";
    }
   @RequestMapping("/categorysave")
    public String createCategory(Model model){
        model.addAttribute("category", new Category());
        return "category";
    }

   @RequestMapping(value = "/registerQuestion", method = RequestMethod.POST)
    String saveQuestion(@ModelAttribute("answers") ArrayList<Answer> answers){
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

