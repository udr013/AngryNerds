package eu.programit.Domain;

/**
 * Created by udr013 on 1-6-2016.
 */
public class Answer {
	
	String answer;
	boolean correct;
	String explanation;
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isCorrect() {
		return correct;
	}
	/*public void setCorrect(boolean correct) {
		this.correct = correct;
	}*/
	String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
}
