package eu.programit.controller;


import eu.programit.domain.*;
import eu.programit.service.IQuestionService;
import eu.programit.service.ITestViewsService;
import eu.programit.service.TestViewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExamController {
	private String toTheIndexPage = "index";
	private String toTheAddQuestionToExamPage = "addQuestToExam";

	TestViewsContent mySelectedQuestions;
	TestViews myTestView;

    @Autowired
    ITestViewsService iTestViewsService;

    @Autowired
    IQuestionService iQuestionService;

    @RequestMapping(value = "/examsave", method = RequestMethod.POST)
    String createExam(@ModelAttribute("testviews") TestViews testViews, Model model) {
        System.out.println("this is createExam" + testViews);
        iTestViewsService.saveTestViews(testViews);
        List<TestViews> testViewses= (List<TestViews>) iTestViewsService.findAll();
        TestViews latestTest = testViewses.get(testViewses.size()-1);
        testViews = iTestViewsService.findById(latestTest.getId());
        model.addAttribute("latesttestview",testViews );
        model.addAttribute("questions", iQuestionService.findAll());
        model.addAttribute("selectedQuestions", new ArrayList<Question>() {
        });
        ExamQuestionSelectedForm examQuestionSelectedForm = new ExamQuestionSelectedForm();
        return toTheAddQuestionToExamPage;
    }

    @RequestMapping(value = "/saveQuestToExam", method = RequestMethod.POST)   
    public String saveQuestToExam(@ModelAttribute ExamQuestionSelectedForm examQuestionSelectedForm ) {
    	System.out.println("in save question to exam"+examQuestionSelectedForm);
    	mySelectedQuestions.setTestViewsContent(new Integer(myTestView.getId()),
				examQuestionSelectedForm.getSelectedQuestions());
    	System.out.println("in save question to exam");
	//	myTestView.getNextQuestion();
	//	mySelectedQuestions.printValues();
    //  User user = iUserService.findByName(principal.getName());
    //   mySelectedQuestions.setUser(user);
//        mySelectedQuestions.setExamId(myTestView.getId());
    	

        return toTheIndexPage;
    }
}

