package eu.programit.domain;

import java.util.ArrayList;
import java.util.List;

public class ExamQuestionSelectedForm {
	
	public ExamQuestionSelectedForm() {
		this.examQuestionsSelected = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return "ExamQuestionSelectedForm [examQuestionsSelected=" + examQuestionsSelected + "]";
	}

	private List<Integer> examQuestionsSelected;

	public List<Integer> getSelectedQuestions() {
		return examQuestionsSelected;
	}

	public void setTestAnswers(List<Integer> examQuestionsSelected) {
		this.examQuestionsSelected = examQuestionsSelected;
	} 

}
