package eu.programit;

import eu.programit.Domain.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * Created by udr013 on 8-6-2016.
 */
@Component
public interface QuestionRepository extends CrudRepository<Question,Long> {
}
