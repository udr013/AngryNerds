package eu.programit.domain;

//@Entity
public class Category {
	
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
	
	

}
