package eu.programit.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
* This table is used by table Test.
* Tests are defined in table Test. This table contains the questions of each tests.
*/

@Entity
public class TestContent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "testId")
//	int testViewsId;// Id of Test table for this question
			Test test;	// Test in Test table to which this question belongs
	
	Integer orderNr;	// defines nr of the question within the test
	Integer questionId;	// Id of question
	
	// map questions to exam
    @Column(columnDefinition = "BLOB")
    @ElementCollection(targetClass = ArrayList.class)
    //Key = questionID  value list of answerIDs
    private Map<Integer, List<Integer>> testContent = new HashMap<>();
	
	/****** Vars  NOT in DB   ******************************************************/
/*	
	@Transient
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="myQuestionId")
	private Question question;
*/	
	/****** Getters & Setters ******************************************************/
	
	public Test getTest() {
		return test;
	}
	 public Map<Integer, List<Integer>> getTestContent() {
	        return testContent;
	    }
	 public void setTestContent(Integer examID, List<Integer> questionList) {
		 System.out.println("in de setTestContent in TestContent" +questionList );
	        this.testContent.put(examID, questionList);
	    }
	public void setTest(Test test) {
		this.test = test;
	}
	public Integer getOrderNr() {
		return orderNr;
	}
	public void setOrderNr(Integer orderNr) {
		this.orderNr = orderNr;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public Integer getId() {
		return id;
	}

//	public void setSelectedQuestion(Integer examId, List<Integer> selectedQuestions) {
//        this.testViewsContent.put(examId, selectedQuestions);
//    }
	 public void setSelectedQuestions(Integer examId, List<Integer> selectedQuestions) {
		 System.out.println("we zitten erin:");
	        this.testContent.put(examId, selectedQuestions);
	    }

	@Override
	public String toString() {
		return "TestContent{" +
				"id=" + id +
				", test=" + test +
				", orderNr=" + orderNr +
				", questionId=" + questionId +
				'}';
	}
	
}
