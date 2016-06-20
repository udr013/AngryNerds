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
import eu.programit.domain.TestAnswerForm;
import eu.programit.domain.TestResults;
import eu.programit.domain.TestViews;
import eu.programit.domain.TestViewsContent;
import eu.programit.repository.TestViewsRepository;
import eu.programit.service.IAnswerService;
import eu.programit.service.IQuestionService;
import eu.programit.service.TestViewsService;

@Controller
public class TakeTestController {

//	int questionCounter = 1;
	TestResults  myTestResults = new TestResults();
	TestViews myTestView;
//	List<TestViewsContent> myTestsList;
	
	@Autowired
	IQuestionService iQuestionService;
	
	@Autowired
	IAnswerService iAnswerService;
	
	@Autowired
	TestViewsService testViewsService;
	
    @RequestMapping(value = "/loadExamQuestion", method = RequestMethod.GET)
    public String LoadExamQuestion(Model model, TestAnswerForm testAnswerForm) {
    	Question q;
    	List<Answer> answers = null;
    	try {
//    		q = iQuestionService.findById(questionCounter);
    		q = iQuestionService.findById(myTestView.getCurrentQuestion().getQuestionId());
        	answers = q.getAnswers();
    	} catch (NullPointerException npe) {
    		q = new Question();
    		q.setContent("Unknown question requested (questionID does not exist)");
    	}
//    	questionCounter++;
        //System.out.println("TakeTestCont: questionCounter = " + questionCounter);
    	model.addAttribute("question", q);//the 1 will get question 2 (index 0)
        
        model.addAttribute("answers", answers);
        model.addAttribute("mytestview", myTestView);
//        model.addAttribute("myanswers", myTestResults.getTestResults(myTestView.getQuestionNr()));
        
    	//model.addAttribute("selectedAnswers", selectedAnswers);
 
    	return "examquestion";
    }
    
    @RequestMapping(value = "/loadExamQuestion", method = RequestMethod.POST)
    public String LoadExamQuestionPOST(@ModelAttribute TestAnswerForm testAnswerForm) {
    	List<Integer> answ = testAnswerForm.getTestAnswers();
		if (answ != null) {
			for (int s : answ) {
				System.out.println("Answer = " + s);
			}
		}
		myTestResults.setTestResults(new Integer(myTestView.getCurrentQuestion().getQuestionId()), testAnswerForm.getTestAnswers());
    	return "redirect:/loadExamQuestion";
    	
    }
    
    // Select a Test          *********************************************************************

    @RequestMapping("/SelectTest")
    public String selectTest(Model model){
    	Iterable<TestViews> tv = testViewsService.findAll();
    	model.addAttribute("testviews", tv);
        return "SelectTest";
    }

    // Start a new Test       *********************************************************************
    
    @RequestMapping(value = "/StartTest", method = RequestMethod.POST)
    public String startTest(@ModelAttribute TestSelection testSelection){
    	myTestView = testViewsService.findById(1);
    	System.out.println("Selected TEst: " + testSelection.selectedTest);
//    	myTestsList = myTestView.getsortedTestViewsList();
    	
    	// test output start
//    	for (TestViewsContent t: myTestsList){
//    		System.out.println("Tests: " + t.getOrderNr() + " " + t.getQuestionId());
//    	}
//    	System.out.println("First Question: " + myTestView.getQuestionNr(1).getQuestionId());
    	// test output end

    	myTestView.startTest();
    	return "redirect:/loadExamQuestion";
    }
    
    // Load Next Question     *********************************************************************
    
    @RequestMapping(value = "/LoadNextQuestion", method = RequestMethod.POST)
    public String loadNextQuestion(@ModelAttribute TestAnswerForm testAnswerForm){
		myTestResults.setTestResults(new Integer(myTestView.getCurrentQuestion().getQuestionId()), testAnswerForm.getTestAnswers());
		myTestView.getNextQuestion();
		myTestResults.printValues();
    	return "redirect:/loadExamQuestion";
    }

    // Load Previous Question *********************************************************************
    
    @RequestMapping(value = "/LoadPrevQuestion", method = RequestMethod.POST)
    public String loadPrevQuestion(@ModelAttribute TestAnswerForm testAnswerForm){
		myTestResults.setTestResults(new Integer(myTestView.getCurrentQuestion().getQuestionId()), testAnswerForm.getTestAnswers());
		myTestView.getPrevQuestion();
		myTestResults.printValues();
		if (testAnswerForm.getTestAnswers() != null) {
			for (int s : testAnswerForm.getTestAnswers()) {
				System.out.println("Answer = " + s);
			}
		}
    	return "redirect:/loadExamQuestion";
    }

}

class TestSelection {
	int selectedTest;
}