package eu.programit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.programit.domain.Category;
import eu.programit.repository.CategoryRepository;
@Service
public class CategoryService implements ICategoryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QuestionService.class);
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	/*
	@Override
	public void saveCategory(Category category) {
		
		LOGGER.debug("it rocks");
		
		Category result = this.categoryRepository.save(category);	
		
		//return result;

	}
	*/
	
	public Iterable<Category> findAll() {
		Iterable<Category> result = this.categoryRepository.findAll();
		
		return result;
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
