package eu.programit.controller;


import eu.programit.domain.*;
import eu.programit.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {



    @Autowired
    QuestionRepository questionRepository;

    @RequestMapping(value = "/loadExam", method = RequestMethod.GET)
    public String Start(@ModelAttribute("examType") String examType) {
        Question q = new Question();
        q.setQuestionID(12);
        q.setQuestion("Would the following code compile?");
        q.setDifficulty(Difficulty.EASY);
        SourceCode code = new SourceCode();
        code.setCode("<pre>\n" +
                "<a name=\"l1\"><span class=\"ln\">1    </span></a><span class=\"s0\">package </span><span class=\"s1\">eu.programit.Domain</span><span class=\"s0\">;</span><span class=\"s1\"> \n" +
                "<a name=\"l2\"><span class=\"ln\">2    </span></a> \n" +
                "<a name=\"l3\"><span class=\"ln\">3    </span></a></span><span class=\"s2\">/** \n" +
                "<a name=\"l4\"><span class=\"ln\">4    </span></a> * Created by udr013 on 1-6-2016. \n" +
                "<a name=\"l5\"><span class=\"ln\">5    </span></a> */</span><span class=\"s1\"> \n" +
                "<a name=\"l6\"><span class=\"ln\">6    </span></a></span><span class=\"s0\">public class </span><span class=\"s1\">Answer { \n" +
                "<a name=\"l7\"><span class=\"ln\">7    </span></a>     \n" +
                "<a name=\"l8\"><span class=\"ln\">8    </span></a>    </span><span class=\"s0\">private </span><span class=\"s1\">String answer</span><span class=\"s0\">;</span><span class=\"s1\"> \n" +
                "<a name=\"l9\"><span class=\"ln\">9    </span></a>    </span><span class=\"s0\">private boolean </span><span class=\"s1\">correct</span><span class=\"s0\">;</span><span class=\"s1\"> \n" +
                "<a name=\"l10\"><span class=\"ln\">10   </span></a>    </span><span class=\"s0\">private </span><span class=\"s1\">String explanation</span><span class=\"s0\">;</span><span class=\"s1\"> \n" +
                "<a name=\"l11\"><span class=\"ln\">11   </span></a>     \n" +
                "<a name=\"l12\"><span class=\"ln\">12   </span></a>    </span><span class=\"s0\">public void </span><span class=\"s1\">setCorrect(</span><span class=\"s0\">boolean </span><span class=\"s1\">correct) { \n" +
                "<a name=\"l13\"><span class=\"ln\">13   </span></a>        </span><span class=\"s0\">this</span><span class=\"s1\">.correct = correct</span><span class=\"s0\">;</span><span class=\"s1\"> \n" +
                "<a name=\"l14\"><span class=\"ln\">14   </span></a>    } \n" +
                "<a name=\"l15\"><span class=\"ln\">15   </span></a>    </span><span class=\"s0\">public </span><span class=\"s1\">String getAnswer() { \n" +
                "<a name=\"l16\"><span class=\"ln\">16   </span></a>        </span><span class=\"s0\">return </span><span class=\"s1\">answer</span><span class=\"s0\">;</span><span class=\"s1\"> \n" +
                "<a name=\"l17\"><span class=\"ln\">17   </span></a>    } \n" +
                "<a name=\"l18\"><span class=\"ln\">18   </span></a>    </span><span class=\"s0\">public void </span><span class=\"s1\">setAnswer(String answer) { \n" +
                "<a name=\"l19\"><span class=\"ln\">19   </span></a>        </span><span class=\"s0\">this</span><span class=\"s1\">.answer = answer</span><span class=\"s0\">;</span><span class=\"s1\"> \n" +
                "<a name=\"l20\"><span class=\"ln\">20   </span></a>    } \n" +
                "<a name=\"l21\"><span class=\"ln\">21   </span></a>    </span><span class=\"s0\">public boolean </span><span class=\"s1\">isCorrect() { \n" +
                "<a name=\"l22\"><span class=\"ln\">22   </span></a>        </span><span class=\"s0\">return </span><span class=\"s1\">correct</span><span class=\"s0\">;</span><span class=\"s1\"> \n" +
                "<a name=\"l23\"><span class=\"ln\">23   </span></a>    } \n" +
                "<a name=\"l24\"><span class=\"ln\">24   </span></a>    String getExplanation() { \n" +
                "<a name=\"l25\"><span class=\"ln\">25   </span></a>        </span><span class=\"s0\">return </span><span class=\"s1\">explanation</span><span class=\"s0\">;</span><span class=\"s1\"> \n" +
                "<a name=\"l26\"><span class=\"ln\">26   </span></a>    } \n" +
                "<a name=\"l27\"><span class=\"ln\">27   </span></a>    </span><span class=\"s0\">public void </span><span class=\"s1\">setExplanation(String explanation) { \n" +
                "<a name=\"l28\"><span class=\"ln\">28   </span></a>        </span><span class=\"s0\">this</span><span class=\"s1\">.explanation = explanation</span><span class=\"s0\">;</span><span class=\"s1\"> \n" +
                "<a name=\"l29\"><span class=\"ln\">29   </span></a>    } \n" +
                "<a name=\"l30\"><span class=\"ln\">30   </span></a>} \n" +
                "<a name=\"l31\"><span class=\"ln\">31   </span></a></span></pre>\n");
        //q.addCode(code);

        return "question.html";
    }





}

