package eu.programit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.programit.domain.Category;
import eu.programit.repository.CategoryRepository;
@Service
public class CategoryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QuestionService.class);
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Iterable<Category> findAll() {
		Iterable<Category> result = this.categoryRepository.findAll();
		
		LOGGER.info("The result of the findAll for all Categories is [{}]", result);
		
		return result;
	}

	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category findById(int id) {
		return this.categoryRepository.findOne(id);
	}

}
