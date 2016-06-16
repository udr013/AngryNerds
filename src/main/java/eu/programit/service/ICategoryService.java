package eu.programit.service;

import eu.programit.domain.Category;
import eu.programit.domain.Question;
import eu.programit.repository.CategoryRepository;

public interface ICategoryService extends CategoryRepository{

	void saveCategory(Category category);



	    Iterable<Category> findAll();
	    
	    Category findById(int id);

}
