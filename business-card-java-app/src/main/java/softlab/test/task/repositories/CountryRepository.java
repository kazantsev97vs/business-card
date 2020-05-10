package softlab.test.task.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import softlab.test.task.entities.citizenship.Country;
import softlab.test.task.interfaces.SpecificBaseEntityCRUD;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>, SpecificBaseEntityCRUD<Country> {
}
