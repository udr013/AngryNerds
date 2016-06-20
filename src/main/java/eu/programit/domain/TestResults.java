package eu.programit.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestResults {

	// map questions to answers
	Map<Integer, List<Integer>> testResults = new HashMap<>();

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
