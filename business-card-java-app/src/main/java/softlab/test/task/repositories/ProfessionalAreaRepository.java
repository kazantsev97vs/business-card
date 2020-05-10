package softlab.test.task.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import softlab.test.task.entities.experience.ProfessionalArea;
import softlab.test.task.interfaces.SpecificBaseEntityCRUD;

@Repository
public interface ProfessionalAreaRepository
        extends CrudRepository<ProfessionalArea, Long>, SpecificBaseEntityCRUD<ProfessionalArea> {
}