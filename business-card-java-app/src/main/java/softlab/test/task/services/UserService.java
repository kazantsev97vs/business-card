package softlab.test.task.services;

import softlab.test.task.entities.User;
import softlab.test.task.interfaces.CRUD;

/**
 * CRUD-сервис для сущности "Пользователь"
 */
public interface UserService extends CRUD<User, Long> {
}