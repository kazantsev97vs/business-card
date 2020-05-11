package softlab.test.task.services.impl;

import org.springframework.stereotype.Service;
import softlab.test.task.entities.User;
import softlab.test.task.interfaces.impl.LoggingCRUDImpl;
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
}