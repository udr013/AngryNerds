package eu.programit.domain;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category implements Serializable{

	private static final long serialVersionUID = -8878362315044398411L;

	// technical key
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String chapter;
	private Question questions;

	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public Question getQuestions() {
		return questions;
	}
	public void setQuestions(Question questions) {
		this.questions = questions;
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
		return "Category [name=" + name + ", chapter=" + chapter + ", questions=" + questions + "]";
	}
}
