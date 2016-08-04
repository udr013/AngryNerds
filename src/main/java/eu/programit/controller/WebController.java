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
	private  String toTheCreateNewCategoryPage = "category";
	private  String toTheLoginPage = "login";
	private static String toTheIndexPage = "index";
	private static String toTheNextQuestionOfTheExamPage = "redirect:/loadExamQuestion";
	private static String toTheAddAnswersToTheQuestionPage = "vraag";
	private static String toTheAddExamToTheDatabasePage = "addExam";

    @Autowired
    ICategoryService iCategoryService;

    @Autowired
    IQuestionService iQuestionService;
    
    @Autowired
    IAnswerService iAnswerService;

    @RequestMapping("/")
    public String start(){
        return toTheLoginPage;
    }

    @RequestMapping("/login")
    public String login (){
        return toTheLoginPage;
    }

    @RequestMapping("/index")
    public String index (){
        return toTheIndexPage;
    }
  //onderstaande methode zorgt voor het volgende:
  //als je na de pagina localhost:8888/vraag gaat, dan handeld deze methode het af en geeft aan de pagina via de variable model
  //gegevens mee aan de webpagina deze kunnen vervolgens door thymeleaf worden gebruikt, hij geeft dus een leeg object van 
  //Question mee, zodat alle velden hiervan beschikbaar zijn voor de pagina tevens haalt die alle categorien op voor het pulldown
  //menu op de pagina, zodat die is geveld met alle categorien die op dat moment in de database zitten.
    @RequestMapping("/vraag")
    public String createQuestion(Model model){
        model.addAttribute("question", new Question());
        model.addAttribute("categories", iCategoryService.findAll());
        return toTheAddAnswersToTheQuestionPage;
    }
    //onderstaande methode zorgt voor het volgende:
    //als je na de pagina localhost:8888/createexam gaat, dan handeld deze methode het af en geeft aan de pagina via de variable model
    //gegevens mee aan de webpagina deze kunnen vervolgens door thymeleaf worden gebruikt, hij geeft dus een leeg object van 
    //ExamView mee, zodat alle velden hiervan beschikbaar zijn voor de pagina op te roepen via de variablee testviews in de pagina zelf
    //Als die klaar is gaat die naar de pagina addExam
    @RequestMapping("/createexam")
    public String createExam(Model model) {
        model.addAttribute("testviews", new Test());

        return toTheAddExamToTheDatabasePage;
    }
    //onderstaande methode zorgt voor het volgende:
    //als je na de pagina localhost:8888/categorysave gaat, kun je via de variable category in thymeleaf de variabelen van Category
    //bereiken en vullen als je die vervolgens op de pagina submit, dan zorgt de pagina category ervoor dat deze worden opgeslagen in de database
    @RequestMapping("/categorysave")
    public String createCategory(Model model){
        model.addAttribute("category", new Category());
        return toTheCreateNewCategoryPage;
    }

    //onderstaande methode zorgt voor het volgende:
    //als je na de pagina localhost:8888/registerQuestion gaat, geeft het POST aan dat die daar invoer verwacht
    //op de pagina laat die alle antwoorden zien die bij de vraag horen die die via het model reeds binnen krijgt
    @RequestMapping(value = "/registerQuestion", method = RequestMethod.POST)
    String saveQuestion(@ModelAttribute("answers") ArrayList<Answer> answers){
        for(Answer x:answers) {
            System.out.println(x);
        }
        return toTheNextQuestionOfTheExamPage;
    }


    @Autowired
    private ErrorAttributes errorAttributes;

    @Bean
    public AppErrorController appErrorController(){return new AppErrorController(errorAttributes);}


}

