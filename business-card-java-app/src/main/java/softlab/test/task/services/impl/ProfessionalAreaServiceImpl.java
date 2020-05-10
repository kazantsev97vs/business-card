package softlab.test.task.services.impl;

import org.springframework.stereotype.Service;
import softlab.test.task.entities.experience.ProfessionalArea;
import softlab.test.task.interfaces.impl.SpecificBaseEntityCRUDImpl;
import softlab.test.task.repositories.ProfessionalAreaRepository;
import softlab.test.task.services.ProfessionalAreaService;

/**
 * Реализация CRUD-сервиса для сущности "Профессиональная область"
 */
@Service
public class ProfessionalAreaServiceImpl
        extends SpecificBaseEntityCRUDImpl<ProfessionalArea, Long, ProfessionalAreaRepository>
        implements ProfessionalAreaService {

    public ProfessionalAreaServiceImpl(ProfessionalAreaRepository repository) { super(repository); }
}