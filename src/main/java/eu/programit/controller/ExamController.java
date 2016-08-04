package eu.programit.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.programit.domain.Test;
import eu.programit.domain.TestContent;
import eu.programit.repository.TestContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.programit.domain.ExamQuestionSelectedForm;
import eu.programit.domain.Question;
import eu.programit.service.IQuestionService;
import eu.programit.service.ITestService;

@Controller
public class ExamController {
	private String toTheIndexPage = "index";
	private String toTheAddQuestionToExamPage = "addQuestToExam";

	TestContent mySelectedQuestions= new TestContent() ;
	Test myTest;

    @Autowired
    TestContentRepository testContentRepository;

    @Autowired
    ITestService iTestService;
    
//    @Autowired
//    IExamService iExamService;

    @Autowired
    IQuestionService iQuestionService;

    @RequestMapping(value = "/examsave", method = RequestMethod.POST)
    String createExam(@ModelAttribute("testviews") Test test, Model model, ExamQuestionSelectedForm examQuestionSelectedForm) {
        System.out.println("this is createExam" + test);
        Question q;
        iTestService.saveTestViews(test);
        List<Test> testViewses= (List<Test>) iTestService.findAll();
        Test latestTest = testViewses.get(testViewses.size()-1);
        test = iTestService.findById(latestTest.getId());
        
      //  ExamQuestionSelectedForm examQuestionSelectedForm = new ExamQuestionSelectedForm();
        try {
			q = iQuestionService.findById(myTest.getCurrentQuestion().getQuestionId());
		//	answers = q.getAnswers();
		} catch (NullPointerException npe) {
			q = new Question();
			q.setContent("Unknown question requested (questionID does not exist)");
		}
        model.addAttribute("latesttestview", test);
        model.addAttribute("questions", iQuestionService.findAll());
        model.addAttribute("examQuestionSelectedForm",examQuestionSelectedForm);
        model.addAttribute("selectedQuestions", new ArrayList<Question>() {
        });
   //     examQuestionSelectedForm.setTestAnswers(mySelectedQuestions.getTestViewsContent().get(q.getQuestionID()));
	//	model.addAttribute("mySelectedQuestions", mySelectedQuestions.getTestViewsContent().get(q.getQuestionID()));
        System.out.println("this is createExam" + test);
        this.myTest = test;
        return toTheAddQuestionToExamPage;
    }

    @RequestMapping(value = "/saveQuestToExam", method = RequestMethod.POST)   
    public String saveQuestToExam(@ModelAttribute ExamQuestionSelectedForm examQuestionSelectedForm ) {
    	System.out.println("in save question to exam"+examQuestionSelectedForm);
    	
    	System.out.println("controlere:"+ myTest.getId());
    	List<Integer> answ = examQuestionSelectedForm.getSelectedQuestions();
    	if (answ != null) {
    	    int ordernr = 0;
			for (int s : answ) {
			    ordernr++;
	//			System.out.println("Question selected = " + s + " het Id ="+new Integer(myTest.getId()) );
	//			mySelectedQuestions.setSelectedQuestion(new Integer(myTest.getId()), s.g);
                TestContent testContent = new TestContent();
                testContent.setQuestionId(s);
                testContent.setTest(myTest);
                testContent.setOrderNr(ordernr);
                testContentRepository.save(testContent);

			}
			//ordernr =0;
		}
    	try{
    		Map<Integer, List<Integer>> testContent = new HashMap<>();
    		testContent.put(myTest.getId(), answ);
    //		mySelectedQuestions.setSelectedQuestions((Map<Integer, List<Integer>>) answ);
    	//	mySelectedQuestions.setSelectedQuestions(testViewsContent);
    	mySelectedQuestions.setSelectedQuestions(myTest.getId(),answ);
  //  	iExamService.saveExam(mySelectedQuestions);
    	}catch (NullPointerException npe) {
    		System.out.println("nullpointer");
    	}
    	System.out.println("this is createExam" + myTest);
//    	mySelectedQuestions.setTestViewsContent(new Integer(myTest.getId()),
//				examQuestionSelectedForm.getSelectedQuestions());
    	System.out.println("in save question to exam");
	//	myTest.getNextQuestion();
	//	mySelectedQuestions.printValues();
    //  User user = iUserService.findByName(principal.getName());
    //   mySelectedQuestions.setUser(user);
//        mySelectedQuestions.setExamId(myTest.getId());
    	

        return toTheIndexPage;
    }
}

