package eu.programit.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestResults {
	
	// map questions to answers
	Map<Integer, List<Integer>> testResults = new HashMap<>();

	public List<Integer> getTestResults(int questionNr) {
		return testResults.get(questionNr);
	}

	public void setTestResults(Integer question, List<Integer> answerList) {
		this.testResults.put(question, answerList);
	}

	
}
