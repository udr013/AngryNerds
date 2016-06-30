package eu.programit.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer implements Serializable {

	public Answer(){}
	public Answer(Question question){

	}

	private static final long serialVersionUID = -5754502589407713275L;

	@ManyToOne
	@JoinColumn(name = "questionid")
	private Question question;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int answerID;

	@Column(columnDefinition = "TEXT")
	private String content;

	@Column(nullable = false, columnDefinition = "INT default 0")
	private boolean correct;

	@Column(columnDefinition = "TEXT")
	private String explanation;

	public int getAnswerID() {
		return answerID;
	}

	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isCorrect() {
		return correct;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	@Override
	public String toString() {
		return "Answer{" +
				"question=" + question +
				", answerID=" + answerID +
				", content='" + content + '\'' +
				", correct=" + correct +
				", explanation='" + explanation + '\'' +
				'}';
	}
}
