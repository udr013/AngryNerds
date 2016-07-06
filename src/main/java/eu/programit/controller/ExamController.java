package eu.programit.controller;


import java.util.ArrayList;
import java.util.List;

import eu.programit.domain.TestQuestionsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.programit.domain.Question;
import eu.programit.domain.TestViews;
import eu.programit.service.QuestionService;
import eu.programit.service.TestViewsService;

@Controller
public class ExamController {


    @Autowired
    private TestViewsService testViewsService;

    @Autowired
    private QuestionService questionService;

    private TestQuestionsForm testQuestionsForm;

    @RequestMapping(value = "/examsave", method = RequestMethod.POST)
    String createExam(@ModelAttribute("testviews") TestViews testViews, Model model, TestQuestionsForm testQuestionsForm) {
        System.out.println("this is" + testViews);
        testViewsService.saveTestViews(testViews);
        List<TestViews> testViewses= (List<TestViews>) testViewsService.findAll();
        TestViews latestTest = testViewses.get(testViewses.size()-1);
	testViews = testViewsService.findById(latestTest.getId());
        model.addAttribute("latesttestview",testViews );
        model.addAttribute("questions", questionService.findAll());
        model.addAttribute("selectedQuestions", new ArrayList<Question>());
        

        return "addQuestToExam";
    }

    @RequestMapping(value = "/saveQuestToExam", method = RequestMethod.POST)
    public String saveQuestToExam(@ModelAttribute ("testQuestionForm")TestQuestionsForm testQuestionsForm) {
        if(testQuestionsForm.getTestQuestions() !=null) {
            for (int q : testQuestionsForm.getTestQuestions()) {
                System.out.println(q);
            }
        }

        return "index";
    }
}

