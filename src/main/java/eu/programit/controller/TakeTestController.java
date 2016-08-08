package eu.programit.controller;

import eu.programit.domain.*;
import eu.programit.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TakeTestController {

	private TestResult myTestResult;
	private Test myTest;
	// List<TestContent> myTestsList;

	@Autowired
	IQuestionService iQuestionService;

	@Autowired
	IUserService iUserService;

	@Autowired
	ITestResultService iTestResultService;

	@Autowired
	IAnswerService iAnswerService;

	@Autowired
	ITestService testService;

	@RequestMapping(value = "/loadExamQuestion", method = RequestMethod.GET)
	public String LoadExamQuestion(Model model, TestAnswerForm testAnswerForm, Principal principal) {
		Question q;
		List<Answer> answers = null;
		try {
			q = iQuestionService.findById(myTest.getCurrentQuestion().getQuestionId());
			answers = q.getAnswers();
		} catch (NullPointerException npe) {
			q = new Question();
			q.setContent("Unknown question requested (questionID does not exist)");
		}
		model.addAttribute("numberCorrect", getCorrectAnswers(answers));
		model.addAttribute("question", q);// the 1 will get question 2 (index 0)
		model.addAttribute("answers", answers);
		model.addAttribute("mytest", myTest);

		testAnswerForm.setTestAnswers(myTestResult.getTestResults().get(q.getQuestionID()));
		model.addAttribute("mytestresults", myTestResult.getTestResults().get(q.getQuestionID()));

		return "ExamQuestion";
	}

	// Leandro: getNrOfCorrectAnswers komt volgens mij meer overeen met de functionaliteit
	private int getCorrectAnswers(List<Answer> answers) {
		int count = 0;
		//System.out.println(answers);
		if (answers != null) {
			for (Answer answer : answers) {
				if (answer.isCorrect()) {
					count++;
				}
			}
		}
		System.out.println("waarde van count: " + count);

		return count;
	}

	@RequestMapping(value = "/loadExamQuestion", method = RequestMethod.POST)
	public String LoadExamQuestionPOST(@ModelAttribute TestAnswerForm testAnswerForm, Principal principal) {
		List<Integer> answers = testAnswerForm.getTestAnswers();
		if (answers != null) {
			for (int s : answers) {
				System.out.println("Answer = " + s + principal.getName());

			}
		}
		myTestResult.setTestResults(myTest.getCurrentQuestion().getQuestionId(),
				testAnswerForm.getTestAnswers());
		System.out.println(myTestResult);
		return "redirect:/loadExamQuestion";

	}

	// Select a Test
	// *********************************************************************

	@RequestMapping("/SelectTest")
	public String selectTest(Model model) {
		Iterable<Test> tv = testService.findAll();
		model.addAttribute("testviews", tv);
		model.addAttribute("testview", new Test());
		return "SelectTest";
	}

	// Start a new Test
	// *********************************************************************

	@RequestMapping(value = "/StartTest", method = RequestMethod.POST)
	public String startTest(@ModelAttribute("testview") Test test, Principal principal) {
		if (test.getId() == 0) return "redirect:/SelectTest";
		myTestResult = new TestResult();
		myTest = testService.findById(test.getId());
		System.out.println("Selected TEst: " + test.getId() + "gebruiker:" + principal.getName());
		// myTestsList = myTest.getsortedTestViewsList();

		// test output start
		// for (TestContent t: myTestsList){
		// System.out.println("Tests: " + t.getOrderNr() + " " +
		// t.getQuestionId());
		// }
		// System.out.println("First Question: " +
		// myTest.getQuestionNr(1).getQuestionId());
		// test output end

		myTest.startTest();
		return "redirect:/loadExamQuestion";
	}

	// Load Next Question
	// *********************************************************************

	@RequestMapping(value = "/LoadNextQuestion", method = RequestMethod.POST)
	public String loadNextQuestion(@ModelAttribute TestAnswerForm testAnswerForm, Principal principal) {
		myTestResult.setTestResults(myTest.getCurrentQuestion().getQuestionId(),
				testAnswerForm.getTestAnswers());
		myTest.getNextQuestion();
		myTestResult.printValues();
		User user = iUserService.findByName(principal.getName());
		myTestResult.setUser(user);
		myTestResult.setExamId(myTest.getId());

		System.out.println(myTestResult);
		// this doesn't work if no catch: nested exception is org.hibernate.PropertyAccessException: could not get a field value by reflection
//       try {

//        }catch (Exception e){
//            System.out.println("file not saved");
//        }
		System.out.println("should be saved by now");
		return "redirect:/loadExamQuestion";
	}

	// Load Previous Question
	// *********************************************************************

	@RequestMapping(value = "/LoadPrevQuestion", method = RequestMethod.POST)
	public String loadPrevQuestion(@ModelAttribute TestAnswerForm testAnswerForm, Principal principal) {
		myTestResult.setTestResults(myTest.getCurrentQuestion().getQuestionId(),
				testAnswerForm.getTestAnswers());
		myTest.getPrevQuestion();
		myTestResult.printValues();
		if (testAnswerForm.getTestAnswers() != null) {
			for (int s : testAnswerForm.getTestAnswers()) {
				System.out.println("Answer = " + s + "gebruiker:" + principal.getName());
			}
		}
		System.out.println(myTestResult);

		return "redirect:/loadExamQuestion";
	}

	// Show All Questions in one overview
	// *********************************************************************

	@RequestMapping(value = "/ShowAllQuestions", method = RequestMethod.POST)
	public String showAllQuestions(Model model, @ModelAttribute TestAnswerForm testAnswerForm) {
		myTestResult.setTestResults(myTest.getCurrentQuestion().getQuestionId(), testAnswerForm.getTestAnswers());
		myTestResult.printValues();
		model.addAttribute("mytestview", myTest);
		model.addAttribute("questionservice", iQuestionService);
		return "ShowAllQuestions";
	}


	// Stop the Test
	// *********************************************************************

	@RequestMapping(value = "/StopTheTest", method = RequestMethod.POST)
	public String stopTheTest(@ModelAttribute TestAnswerForm testAnswerForm) {
		myTestResult.setTestResults(myTest.getCurrentQuestion().getQuestionId(),
				testAnswerForm.getTestAnswers());
		myTestResult.printValues();
		return "StopTheTest";
	}

	// Evaluate the Test
	// *********************************************************************

	@RequestMapping(value = "/TestEvaluation", method = RequestMethod.POST)
	public String testEvaluation( Model model, Principal principal) {
		iTestResultService.saveTestResult(myTestResult);
		User user = iUserService.findByName(principal.getName());

		List<TestResult> testResults= (List<TestResult>) iTestResultService.findByUser(user);
		List<Question> questions= new ArrayList<>();
		TestResult lastTestResult = testResults.get(testResults.size()-1);
		System.out.println(lastTestResult.getTestResultId() );
		Map<Integer, List<Integer>> testResult = lastTestResult.getTestResults();
		double correctQuestions = 0;
		double incorrectQuestions = 0;
		for(Map.Entry<Integer, List<Integer>> element : testResult.entrySet()) {
			int vraagId = element.getKey();
			Question q = this.iQuestionService.findById(vraagId);
			//questions.add(q);
			List<Integer> answers = element.getValue();
			boolean isOK = false;
			// if the questions is answered
			if (answers != null) {
				isOK = true;
				// and evaluate the answers
				for (int a : answers) {
					Answer answer = iAnswerService.findOne(a);
					isOK = isOK && answer.isCorrect();
				}
			}
			if(isOK) {
				q.setCorrect(true);
				questions.add(q);
				correctQuestions++;
			}
			else {
				incorrectQuestions++;
				questions.add(q);
			}

		}

		double score =(100/(correctQuestions+incorrectQuestions))*correctQuestions;
		System.out.println(score);
		model.addAttribute("questions", questions);
		model.addAttribute("score", Math.round(score));
		// Implement overview of all questions
		return "TestEvaluation";
	}

	//display question after exam
	@RequestMapping(value = {"/displayQuestInfo/{id}"}, method = RequestMethod.GET)
	public String displayQuestion(@PathVariable("id") Integer  id,Model model) {
		System.out.println("we have id"+id);
		Question q;
		List<Answer> answers = null;
		try {
			q = iQuestionService.findById(id);
			answers = q.getAnswers();
		} catch (NullPointerException npe) {
			q = new Question();
			q.setContent("Unknown question requested (questionID does not exist)");
		}

		model.addAttribute("question", q);// the 1 will get question 2 (index 0)
		model.addAttribute("answers", answers);


		return "displayQuestionInfo";
	}
}

