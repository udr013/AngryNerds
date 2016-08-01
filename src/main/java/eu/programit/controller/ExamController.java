package eu.programit.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.programit.repository.TestViewsContentRepository;
import eu.programit.service.TestViewsContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.programit.domain.ExamQuestionSelectedForm;
import eu.programit.domain.Question;
import eu.programit.domain.TestViews;
import eu.programit.domain.TestViewsContent;
import eu.programit.service.IQuestionService;
import eu.programit.service.ITestViewsService;

@Controller
public class ExamController {
	private String toTheIndexPage = "index";
	private String toTheAddQuestionToExamPage = "addQuestToExam";

	TestViewsContent mySelectedQuestions= new TestViewsContent() ;
	TestViews myTestView;

    @Autowired
    TestViewsContentRepository testViewsContentRepository;

    @Autowired
    ITestViewsService iTestViewsService;
    
//    @Autowired
//    IExamService iExamService;

    @Autowired
    IQuestionService iQuestionService;

    @RequestMapping(value = "/examsave", method = RequestMethod.POST)
    String createExam(@ModelAttribute("testviews") TestViews testViews, Model model,ExamQuestionSelectedForm examQuestionSelectedForm) {
        System.out.println("this is createExam" + testViews);
        Question q;
        iTestViewsService.saveTestViews(testViews);
        List<TestViews> testViewses= (List<TestViews>) iTestViewsService.findAll();
        TestViews latestTest = testViewses.get(testViewses.size()-1);
        testViews = iTestViewsService.findById(latestTest.getId());
        
      //  ExamQuestionSelectedForm examQuestionSelectedForm = new ExamQuestionSelectedForm();
        try {
			q = iQuestionService.findById(myTestView.getCurrentQuestion().getQuestionId());
		//	answers = q.getAnswers();
		} catch (NullPointerException npe) {
			q = new Question();
			q.setContent("Unknown question requested (questionID does not exist)");
		}
        model.addAttribute("latesttestview",testViews );
        model.addAttribute("questions", iQuestionService.findAll());
        model.addAttribute("examQuestionSelectedForm",examQuestionSelectedForm);
        model.addAttribute("selectedQuestions", new ArrayList<Question>() {
        });
   //     examQuestionSelectedForm.setTestAnswers(mySelectedQuestions.getTestViewsContent().get(q.getQuestionID()));
	//	model.addAttribute("mySelectedQuestions", mySelectedQuestions.getTestViewsContent().get(q.getQuestionID()));
        System.out.println("this is createExam" + testViews);
        this.myTestView=testViews;
        return toTheAddQuestionToExamPage;
    }

    @RequestMapping(value = "/saveQuestToExam", method = RequestMethod.POST)   
    public String saveQuestToExam(@ModelAttribute ExamQuestionSelectedForm examQuestionSelectedForm ) {
    	System.out.println("in save question to exam"+examQuestionSelectedForm);
    	
    	System.out.println("controlere:"+myTestView.getId());
    	List<Integer> answ = examQuestionSelectedForm.getSelectedQuestions();
    	if (answ != null) {
    	    int ordernr = 0;
			for (int s : answ) {
			    ordernr++;
	//			System.out.println("Question selected = " + s + " het Id ="+new Integer(myTestView.getId()) );
	//			mySelectedQuestions.setSelectedQuestion(new Integer(myTestView.getId()), s.g);
                TestViewsContent testViewsContent = new TestViewsContent();
                testViewsContent.setQuestionId(s);
                testViewsContent.setTestViews(myTestView);
                testViewsContent.setOrderNr(ordernr);
                testViewsContentRepository.save(testViewsContent);

			}
			//ordernr =0;
		}
    	try{
    		Map<Integer, List<Integer>> testViewsContent = new HashMap<>();
    		testViewsContent.put(new Integer(myTestView.getId()), answ);
    //		mySelectedQuestions.setSelectedQuestions((Map<Integer, List<Integer>>) answ);
    	//	mySelectedQuestions.setSelectedQuestions(testViewsContent);
    	mySelectedQuestions.setSelectedQuestions(new Integer(myTestView.getId()),answ);
  //  	iExamService.saveExam(mySelectedQuestions);
    	}catch (NullPointerException npe) {
    		System.out.println("nullpointer");
    	}
    	System.out.println("this is createExam" + myTestView);
//    	mySelectedQuestions.setTestViewsContent(new Integer(myTestView.getId()),
//				examQuestionSelectedForm.getSelectedQuestions());
    	System.out.println("in save question to exam");
	//	myTestView.getNextQuestion();
	//	mySelectedQuestions.printValues();
    //  User user = iUserService.findByName(principal.getName());
    //   mySelectedQuestions.setUser(user);
//        mySelectedQuestions.setExamId(myTestView.getId());
    	

        return toTheIndexPage;
    }
}

