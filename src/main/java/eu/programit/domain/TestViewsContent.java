package eu.programit.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/*
* This table is used by table TestViews.
* Tests are defined in table TestViews. This table contains the questions of each tests.
*/

@Entity
public class TestViewsContent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "testViewsId")
//	int testViewsId;// Id of TestViews table for this question
	TestViews testView;	// Test in TestViews table to which this question belongs 
	
	Integer orderNr;	// defines nr of the question within the test
	Integer questionId;	// Id of question
	
	// map questions to exam
    @Column(columnDefinition = "BLOB")
    @ElementCollection(targetClass = ArrayList.class)
    //Key = questionID  value list of answerIDs
    private Map<Integer, List<Integer>> testViewsContent = new HashMap<>();
	
	/****** Vars  NOT in DB   ******************************************************/
/*	
	@Transient
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="myQuestionId")
	private Question question;
*/	
	/****** Getters & Setters ******************************************************/
	
	public TestViews getTestViews() {
		return testView;
	}
	 public Map<Integer, List<Integer>> getTestViewsContent() {
	        return testViewsContent;
	    }
	 public void setTestViewsContent(Map<Integer, List<Integer>> testViewsContent) {
	        this.testViewsContent = testViewsContent;
	    }
	public void setTestViews(TestViews testView) {
		this.testView = testView;
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

	@Override
	public String toString() {
		return "TestViewsContent{" +
				"id=" + id +
				", testView=" + testView +
				", orderNr=" + orderNr +
				", questionId=" + questionId +
				'}';
	}
}
