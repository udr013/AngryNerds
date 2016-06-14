package eu.programit.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Answer implements Serializable {
	
	private static final long serialVersionUID = -5754502589407713275L;

	private static final Logger log = LoggerFactory.getLogger(Answer.class);

    @ManyToOne
    @JoinColumn(name = "questionID", insertable = false, updatable = false)
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
	
	@Column(name = "answer", columnDefinition = "LONGVARBINARY")
	private String answer;
	@Column(name = "correct", nullable = false, columnDefinition = "INT default 0")
	private boolean correct;
	@Column(name = "explanation", columnDefinition = "LONGVARBINARY")
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
		return "Answer [AnswerID=" + answerID + ", answer=" + answer + ", correct=" + correct + ", explanation="
				+ explanation + "]";
	}
	
}
