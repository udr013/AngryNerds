package eu.programit.Domain;

/**
 * Created by udr013 on 1-6-2016.
 */
public class Answer {
	
	private String answer;
	private boolean correct;
	private String explanation;
	
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
}
