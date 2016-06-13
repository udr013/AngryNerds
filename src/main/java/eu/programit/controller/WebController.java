package eu.programit.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eu.programit.domain.Answer;
import eu.programit.domain.Difficulty;
import eu.programit.domain.Question;
import eu.programit.repository.QuestionRepository;
import eu.programit.service.QuestionService;

@Controller
public class WebController {
	@Autowired
	private QuestionService questionService;



    @Autowired
    QuestionRepository questionRepository;
    @RequestMapping(value = "/loadExam", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("name") String name,
			@RequestParam(required = false, value = "renderPresentationNotes") boolean renderPresentationNotes,
			@RequestParam("sourceCode") String sourceCode,	@RequestParam("difficulty") String difficulty,
			@RequestParam("isMarked") boolean isMarked,@RequestParam("status") String status, @RequestParam("feedback") String feedback, 
			@RequestParam("interLink") String interLink,HttpServletResponse response) {

		Question question = new Question();
		question.setQuestion(name);
		question.setCode(sourceCode);
		question.setMarked(isMarked);
		question.setFeedback(feedback);
		question.setInternetLink(interLink);
//		String newLastName= lastName.replaceAll(Character.toString((char)10),"\n\r");
//		newLastName= newLastName.replaceAll(Character.toString((char)9),"\t");
	
//		String toInsert=textAreaWidget.getText().replaceAll(Character.toString((char) 10), "\n\r"));
//
//		person.setLastName(sourceCode);
//		person.setAddress(address);
//		person.setPhone(phone);
//		person.setMail(mail);
//		Category category = new Category();
//		category.setChapter(chapter);
//		category.setName(chapname);
		this.questionService.save(question);
//
//		this.personService.save(person);
//		this.personService.save2(category, person);
		return "list";

	}
//
//    @RequestMapping(value = "/loadExam", method = RequestMethod.GET)
//    public String Start(Model model) {
//        Question q = new Question();
//        q.setQuestionID(12);
//        q.setQuestion("Would the following code compile?");
//        q.setDifficulty(Difficulty.EASY);
//        q.setCode("package eu.programit.domain;\n" +
//            "\n" +
//            "//@Entity\n" +
//            "public class Category {\n" +
//            "\t\n" +
//            "\tprivate String name;\n" +
//            "\tprivate String chapter;\n" +
//            "\tprivate Question questions;\n" +
//            "\t\n" +
//            "\tpublic String getChapter() {\n" +
//            "\t\treturn chapter;\n" +
//            "\t}\n" +
//            "\tpublic void setChapter(String chapter) {\n" +
//            "\t\tthis.chapter = chapter;\n" +
//            "\t}\n" +
//            "\tpublic Question getQuestions() {\n" +
//            "\t\treturn questions;\n" +
//            "\t}\n" +
//            "\tpublic void setQuestions(Question questions) {\n" +
//            "\t\tthis.questions = questions;\n" +
//            "\t}\n" +
//            "\tpublic String getName() {\n" +
//            "\t\treturn name;\n" +
//            "\t}\n" +
//            "\tpublic void setName(String name) {\n" +
//            "\t\tthis.name = name;\n" +
//            "\t}\n" +
//            "\t\n" +
//            "\t\n" +
//            "\n" +
//            "}\n");
//        model.addAttribute("question", q);
//        Answer a = new Answer();
//        a.setAnswer("this class will compile");
//        Answer b = new Answer();
//        b.setAnswer("this class will not compile");
//        List<Answer> answers = new ArrayList<>();
//        answers.add(a);
//        answers.add(b);
//        model.addAttribute("answers", answers);
//        return "question";
//    }

    @RequestMapping("/registerQuestion")
    String saveQuestion(Model model){
        Question q = new Question();
        q.setQuestionID(12);
        q.setQuestion("Would the following code compile?");
        q.setDifficulty(Difficulty.EASY);
        q.setCode("package eu.programit.domain;\n" +
                "\n" +
                "//@Entity\n" +
                "public class Category {\n" +
                "\t\n" +
                "\tprivate String name;\n" +
                "\tprivate String chapter;\n" +
                "\tprivate Question questions;\n" +
                "\t\n" +
                "\tpublic String getChapter() {\n" +
                "\t\treturn chapter;\n" +
                "\t}\n" +
                "\tpublic void setChapter(String chapter) {\n" +
                "\t\tthis.chapter = chapter;\n" +
                "\t}\n" +
                "\tpublic Question getQuestions() {\n" +
                "\t\treturn questions;\n" +
                "\t}\n" +
                "\tpublic void setQuestions(Question questions) {\n" +
                "\t\tthis.questions = questions;\n" +
                "\t}\n" +
                "\tpublic String getName() {\n" +
                "\t\treturn name;\n" +
                "\t}\n" +
                "\tpublic void setName(String name) {\n" +
                "\t\tthis.name = name;\n" +
                "\t}\n" +
                "\t\n" +
                "\t\n" +
                "\n" +
                "}\n");
        model.addAttribute("question", q);
        Answer a = new Answer();
        a.setAnswer("this is an invalid class");
        Answer b = new Answer();
        b.setAnswer("this class will not be recognized in springboot mysql");
        List<Answer> answers = new ArrayList<>();
        answers.add(a);
        answers.add(b);
        model.addAttribute("answers", answers);

        return "question";
    }





}

