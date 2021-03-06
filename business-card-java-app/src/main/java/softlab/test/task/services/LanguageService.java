package softlab.test.task.services;

import softlab.test.task.entities.citizenship.Language;
import softlab.test.task.interfaces.CRUD;
import softlab.test.task.interfaces.SpecificBaseEntityCRUD;

/**
 * CRUD-сервис для сущности "Язык"
 */
public interface LanguageService
        extends CRUD<Language, Long>, SpecificBaseEntityCRUD<Language> {
}