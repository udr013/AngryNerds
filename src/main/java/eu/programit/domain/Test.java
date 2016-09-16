package eu.programit.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Entity
public class Test implements Serializable {

	private static final long serialVersionUID = 6392649144473391793L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String description;
	private String testType;			// Exam, subject, ...
	
	@OneToMany (mappedBy = "test")
	private List<TestContent> testList;

	/****** Local Vars        ******************************************************/

	@Transient
	private int questionNr;
	
	@Transient
	private List<TestContent> sortedTestList;

	/****** Methods           ******************************************************/
	
	public void startTest() {
		// sort questions on order nr
		sortedTestList = new ArrayList<>(testList);
		Collections.sort(sortedTestList,new TestComparator());
	}
		// start with question nr 1 (questionNr is index thus starts with 0)
	class TestComparator implements Comparator<TestContent>{
		public int compare(eu.programit.domain.TestContent a, eu.programit.domain.TestContent b){
			return Integer.compare(a.orderNr, b.orderNr);
		}
	}


	public TestContent getNextQuestion(){
		if (questionNr <sortedTestList.size()-1) questionNr++; // no next question if already at last
		System.out.println("getNextQuestion - sortedTestViewsList.size: " + sortedTestList.size());
		System.out.println("getNextQuestion - sortedTestViewsListIndex: " + questionNr);
		return sortedTestList.get(questionNr);
	}

	public TestContent getPrevQuestion(){
		if (questionNr > 0) questionNr--; // no previous question if already at 1
		return sortedTestList.get(questionNr);
	}

	// Set current question to index and return its value in table sortedTestViewsList 
//	public TestContent getQuestionNr(int index) {
//		if (index >= 0 && index < sortedTestViewsList.size()) questionNr = index;
//		else questionNr = 0;
//		return sortedTestViewsList.get(questionNr);
//	}

	public TestContent getCurrentQuestion() {
		return sortedTestList.get(questionNr);
	}
	
	public int getNrOfQuestions() {
		return sortedTestList.size();
	}

	/****** Getters & Setters ******************************************************/
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<TestContent> getTestList() {
		return testList;
	}

	public void setTestList(List<TestContent> testList) {
		this.testList = testList;
	}

	public int getQuestionNr() {
		return questionNr;
	}

	public void setQuestionNr(int questionNr) {
		this.questionNr = questionNr;
	}

	public List<TestContent> getSortedTestList() {
		return sortedTestList;
	}

	@Override
	public String toString() {
		return "Test{" +
				"id=" + id +
				", description='" + description + '\'' +
				", testType='" + testType + '\'' +
				", testViewsList=" + testList +
				", questionNr=" + questionNr +
				", sortedTestViewsList=" + sortedTestList +
				'}';
	}
}
