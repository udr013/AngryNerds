package eu.programit.Domain;

/**
 * Created by udr013 on 1-6-2016.
 */

enum Status {SUBMITTED, APPROVED}

enum Difficulty {HARD, EASY, MEDIUM}

//@Entity
public class Question {
    
    private String question;
    private String internetLink;
    private SourceCode code;
    private Answer answers;
    private boolean isMarked;
    private Status status;
    private Difficulty difficulty;
    private int questionID;
    private String feedback;
    private boolean hasFeedback;
    
	public boolean isHasFeedback() {
		return hasFeedback;
	}
	public void setHasFeedback(boolean hasFeedback) {
		this.hasFeedback = hasFeedback;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getInternetLink() {
		return internetLink;
	}
	public void setInternetLink(String internetLink) {
		this.internetLink = internetLink;
	}
	public SourceCode removeCode() {
		return code;
	}
	public void addCode(SourceCode code) {
		this.code = code;
	}
	public Answer showAnswers() {
		return answers;
	}
	public boolean getMarked() {
		return isMarked;
	}
	public void setMarked(boolean isMarked) {
		this.isMarked = isMarked;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	public int getQuestionID() {
		return questionID;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}
