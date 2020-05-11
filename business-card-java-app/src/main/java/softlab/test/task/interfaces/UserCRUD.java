package softlab.test.task.interfaces;

import softlab.test.task.entities.User;

public interface UserCRUD {

    User getByLogin(String login);

}