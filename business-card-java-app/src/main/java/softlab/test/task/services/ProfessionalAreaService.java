package softlab.test.task.services;

import softlab.test.task.entities.experience.ProfessionalArea;
import softlab.test.task.interfaces.CRUD;
import softlab.test.task.interfaces.SpecificBaseEntityCRUD;

/**
 * CRUD-сервис для сущности "Профессиональная область"
 */
public interface ProfessionalAreaService
        extends CRUD<ProfessionalArea, Long>, SpecificBaseEntityCRUD<ProfessionalArea> {
}