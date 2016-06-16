package eu.programit.service;

import eu.programit.domain.Category;

public interface ICategoryService{

		Category saveCategory(Category category);



	    Iterable<Category> findAll();
	    
	    Category findById(int id);

}
