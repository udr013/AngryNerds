package eu.programit.controller;


import eu.programit.domain.Answer;
import eu.programit.domain.Difficulty;
import eu.programit.domain.Question;
import eu.programit.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {



    @Autowired
    QuestionRepository questionRepository;

    @RequestMapping(value = "/loadExam", method = RequestMethod.GET)
    public String start(Model model) {
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
        a.setAnswerID(3);
        a.setAnswer("this class will compile");
        Answer b = new Answer();
        b.setAnswerID(5);
        b.setAnswer("this class will not compile");
        List<Answer> answers = new ArrayList<>();
        ArrayList<Answer> selectedAnswers = new ArrayList<>();
        answers.add(a);
        answers.add(b);
        model.addAttribute("answers", answers);
        model.addAttribute("selectedAnswers", selectedAnswers);
        return "question";
    }

    @RequestMapping(value = "/registerQuestion", method = RequestMethod.POST)
    String saveQuestion(Model model, @RequestParam ArrayList<Answer> selectedAnswers){
        for(Answer x:selectedAnswers) {
            System.out.println(x);
        }
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

