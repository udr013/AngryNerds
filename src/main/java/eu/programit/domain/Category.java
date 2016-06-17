package eu.programit.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Category implements Serializable{

	private static final long serialVersionUID = -8878362315044398411L;

	// technical key
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToMany(mappedBy = "category")
	private List<Question> questions;

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	private String name;
	private String chapter;

	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
//		return "Category [name=" + name + ", chapter=" + chapter + "]";
		return "Category [name=" + name + ", chapter=" + chapter + "]";
	}
}
