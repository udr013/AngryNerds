package eu.programit.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Answer implements Serializable {
	
	private static final long serialVersionUID = -5754502589407713275L;

	private static final Logger log = LoggerFactory.getLogger(Answer.class);

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int AnswerID;
	@Column(name = "answer", columnDefinition = "LONGVARBINARY")
	private String answer;
	private boolean correct;
	@Column(name = "explanation", columnDefinition = "LONGVARBINARY")
	private String explanation;
	
	public int getAnswerID() {
		return AnswerID;
	}
	public void setAnswerID(int answerID) {
		AnswerID = answerID;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isCorrect() {
		return correct;
	}
	String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	@Override
	public String toString() {
		return "Answer [AnswerID=" + AnswerID + ", answer=" + answer + ", correct=" + correct + ", explanation="
				+ explanation + "]";
	}
	
}
