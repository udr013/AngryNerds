package eu.programit.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.programit.domain.Question;
import eu.programit.domain.TestViews;
import eu.programit.service.IQuestionService;
import eu.programit.service.TestViewsService;

@Controller
public class ExamController {


    @Autowired
    TestViewsService testViewsService;

    @Autowired
    IQuestionService iQuestionService;

    @RequestMapping(value = "/examsave", method = RequestMethod.POST)
    String createExam(@ModelAttribute("testviews") TestViews testViews, Model model) {
        System.out.println("this is" + testViews);
        testViewsService.saveTestViews(testViews);
        List<TestViews> testViewses= (List<TestViews>) testViewsService.findAll();
        TestViews latestTest = testViewses.get(testViewses.size()-1);
        testViews = testViewsService.findById(latestTest.getId());
        model.addAttribute("latesttestview",testViews );
        model.addAttribute("questions", iQuestionService.findAll());
        model.addAttribute("selectedQuestions", new ArrayList<Question>() {
        });
        return "addQuestToExam";
    }

    @RequestMapping(value = "/saveQuestToExam", method = RequestMethod.POST)
    public String saveQuestToExam(@ModelAttribute("selectedQuestions") ArrayList<Question> question, Model model) {

        System.out.println(question);


        return "index";


    }
}

