package softlab.test.task.services.impl;

import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import softlab.test.task.entities.User;
import softlab.test.task.interfaces.impl.LoggingCRUDImpl;
import softlab.test.task.models.LogInUser;
import softlab.test.task.repositories.UserRepository;
import softlab.test.task.services.UserService;

/**
 * Реализация CRUD-сервиса для сущности "Пользователь"
 */
@Service
public class UserServiceImpl
        extends LoggingCRUDImpl<User, Long, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) { super(repository); }

    @Override
    public User getByLogin(String login) {
        return repository.getByLogin(login);
    }

    @Override
    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }

    @Override
    public Boolean checkEmailUniqueness(String email) {
        return getByEmail(email) == null;
    }

    @Override
    public Boolean checkLoginUniqueness(String login) {
        return getByLogin(login) == null;
    }

    @Override
    public User signUp(User user) {
        return save(user);
    }

    @Override
    public User logIn(LogInUser logInUser) {
        User user = getByLogin(logInUser.getLogin());

        if (user == null) return null;

        if (!user.getPassword().equals(logInUser.getPassword())) return null;

        /*
            Почитать про токены
         */

        return user;
    }

    @Override
    public User logOut(String secret) {
        return null;
    }
}