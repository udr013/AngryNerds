package eu.programit.domain;

import java.util.List;

public class TestQuestionsForm {
    private List<Integer> testQuestions;

    public List<Integer> getTestQuestions() {
        return testQuestions;
    }

    public void setTestAnswers(List<Integer> testQuestions) {
        this.testQuestions = testQuestions;
    }

    @Override
    public String toString() {
        return "TestQuestionsForm{" +
                "testQuestions=" + testQuestions +
                '}';
    }
}
