package softlab.test.task.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import softlab.test.task.entities.citizenship.Language;
import softlab.test.task.interfaces.SpecificBaseEntityCRUD;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>, SpecificBaseEntityCRUD<Language> {
}
