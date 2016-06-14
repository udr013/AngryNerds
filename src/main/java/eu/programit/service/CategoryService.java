package eu.programit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import eu.programit.domain.Category;
import eu.programit.repository.CategoryRepository;

public class CategoryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QuestionService.class);
	
	@Autowired
	private CategoryRepository categoryRepository;

	
	public Category save(Category category) {
		
		LOGGER.debug("it rocks");
		
		Category result = this.categoryRepository.save(category);	
		
		return result;

	}
	
	public Iterable<Category> findAll() {
		Iterable<Category> result = this.categoryRepository.findAll();
		
		return result;
	}

}
