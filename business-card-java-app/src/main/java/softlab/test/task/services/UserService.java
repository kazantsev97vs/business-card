package softlab.test.task.services;

import softlab.test.task.entities.User;
import softlab.test.task.interfaces.CRUD;
import softlab.test.task.interfaces.UserCRUD;
import softlab.test.task.models.LogInUser;

/**
 * CRUD-сервис для сущности "Пользователь"
 */
public interface UserService extends CRUD<User, Long>, UserCRUD {

    Boolean checkEmailUniqueness(String email);

    Boolean checkLoginUniqueness(String login);

    User signUp(User user);

    User logIn(LogInUser logInUser);

    User logOut(String secret);

}