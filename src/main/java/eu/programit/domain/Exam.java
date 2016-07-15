package eu.programit.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Exam implements Serializable{

	private static final long serialVersionUID = 4411933556214276894L;

	private static final Logger log = LoggerFactory.getLogger(Exam.class);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private boolean isParallel;
	private int numberOfQuestions;
	//Commented out because Category is not a field of Exam, but a manner of constructing an specific exam
	//private Category categories;
	private int maxTimelnMinutes;
	
	@ManyToMany(mappedBy="exams", cascade=CascadeType.ALL)
	
	private Collection<Question> questions;

	public boolean isParallel() {
		return isParallel;
	}
	public void setParallel(boolean isParallel) {
		this.isParallel = isParallel;
	}
	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}
	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	/*
	public Category getCategories() {
		return categories;
	}
	public void setCategories(Category categories) {
		this.categories = categories;
	}
	*/
	public int getMaxTimelnMinutes() {
		return maxTimelnMinutes;
	}
	public void setMaxTimelnMinutes(int maxTimelnMinutes) {
		this.maxTimelnMinutes = maxTimelnMinutes;
	}
	public long getId() {
		return id;
	}
	
	public void addQuestion(Question question) {
		this.questions.add(question);
	}
	@Override
	public String toString() {
		return "Exam [id=" + id + ", questions=" + questions + "]";
	}

	
}
