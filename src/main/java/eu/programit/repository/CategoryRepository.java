package eu.programit.repository;


//import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import eu.programit.domain.Category;
//import eu.programit.domain.Question;

@Component
public interface CategoryRepository extends CrudRepository<Category,Integer> {
		
		//Do we need line 14?
	    //Collection<Category> findAllByQuestions(Question id);

}
