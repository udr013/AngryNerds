package eu.programit.Domain;

public class Exam {
	private boolean isParallel;
	private int numberOfQuestions;
	private Category categories;
	private int maxTimelnMinutes;
	
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
	public Category getCategories() {
		return categories;
	}
	public void setCategories(Category categories) {
		this.categories = categories;
	}
	public int getMaxTimelnMinutes() {
		return maxTimelnMinutes;
	}
	public void setMaxTimelnMinutes(int maxTimelnMinutes) {
		this.maxTimelnMinutes = maxTimelnMinutes;
	}
	
	

}
