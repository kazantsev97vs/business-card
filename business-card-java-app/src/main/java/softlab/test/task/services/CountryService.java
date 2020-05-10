package softlab.test.task.services;

import softlab.test.task.entities.citizenship.Country;
import softlab.test.task.interfaces.CRUD;
import softlab.test.task.interfaces.SpecificBaseEntityCRUD;

/**
 * CRUD-сервис для сущности "Страна"
 */
public interface CountryService
        extends CRUD<Country, Long>, SpecificBaseEntityCRUD<Country> {
}