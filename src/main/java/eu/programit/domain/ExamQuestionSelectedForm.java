package eu.programit.domain;

import java.util.List;

public class ExamQuestionSelectedForm {
	private List<Integer> examQuestionsSelected;

	public List<Integer> getSelectedQuestions() {
		return examQuestionsSelected;
	}

	public void setTestAnswers(List<Integer> examQuestionsSelected) {
		this.examQuestionsSelected = examQuestionsSelected;
	} 

}
