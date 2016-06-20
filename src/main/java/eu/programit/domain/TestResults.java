package eu.programit.domain;

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
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="testresults")
public class TestResults {

	@Override
	public String toString() {
		return "TestResults [testResults=" + testResults + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int examID;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private User user;

	// map questions to answers
	@Column(columnDefinition= "BLOB")
	@ElementCollection
	@OneToMany(targetEntity=User.class)  
	private Map<Integer, List<Integer>> testResults = new HashMap<>();

	public int getExamID() {
		return examID;
	}

	public void setExamID(int examID) {
		this.examID = examID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<Integer, List<Integer>> getTestResults() {
		return testResults;
	}

	public void setTestResults(Map<Integer, List<Integer>> testResults) {
		this.testResults = testResults;
	}

	/******
	 * Utility Mehtods
	 ******************************************************/

	public void printValues() {
		if (testResults.size() < 1)
			return;
		for (Integer q : testResults.keySet()) {
			if (testResults.get(q) == null)
				continue;
			for (Integer a : testResults.get(q)) {
				System.out.println("Question: " + q + " | Answer: " + a);
			}
		}
		System.out.println("Nr of answers: " + testResults.size());
	}

	/******
	 * Getters & Setters
	 ******************************************************/

	public List<Integer> getTestResults(int questionNr) {
		return testResults.get(questionNr);
	}

	public void setTestResults(Integer question, List<Integer> answerList) {
		this.testResults.put(question, answerList);
	}

}
