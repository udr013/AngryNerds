package eu.programit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;



@Entity
public class Question implements Serializable {
	
	private static final long serialVersionUID = -8245794906215772189L;
	
	//rvandemaat hier moet ik nog wat log naar toe sturen
	private static final Logger log = LoggerFactory.getLogger(Question.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionID;
	
	@Column(columnDefinition = "LONGVARBINARY")
	private String question;
	
	// might be MEDIUMTEXT here for columnDefinition
	@Column(name = "code", columnDefinition = "LONGVARBINARY")
	private String code;
	
	private Difficulty difficulty;
	private boolean isMarked;
	private Status status;
	
	@Column(name = "feedback", columnDefinition = "LONGVARBINARY")
	private String feedback;
	
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
	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", question=" + question + ", code=" + code + ", difficulty="
				+ difficulty + ", isMarked=" + isMarked + ", status=" + status + ", feedback=" + feedback
				+ ", hasFeedback=" + hasFeedback + ", internetLink=" + internetLink + "]";
	}
}




