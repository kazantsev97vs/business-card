package softlab.test.task.services;

import softlab.test.task.entities.BusinessCard;
import softlab.test.task.interfaces.CRUD;

/**
 * CRUD-сервис для сущности "Визитная карточка"
 */
public interface BusinessCardService extends CRUD<BusinessCard, Long> {
}