package eu.programit.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by udr013 on 1-6-2016.
 */

@Entity
public class Question implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionID;

	private String question;
	private String code;
	private Difficulty difficulty;
	@Column(name = "is_marked", columnDefinition = "INT default 0")
	private boolean isMarked;
	private Status status;
	private String feedback;
	@Column(name = "has_feedback", columnDefinition = "INT default 0")
	private boolean hasFeedback;
	private String internetLink;


	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public boolean isMarked() {
		return isMarked;
	}

	public void setMarked(boolean marked) {
		isMarked = marked;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public boolean isHasFeedback() {
		return hasFeedback;
	}

	public void setHasFeedback(boolean hasFeedback) {
		this.hasFeedback = hasFeedback;
	}

	public String getInternetLink() {
		return internetLink;
	}

	public void setInternetLink(String internetLink) {
		this.internetLink = internetLink;
	}
}




