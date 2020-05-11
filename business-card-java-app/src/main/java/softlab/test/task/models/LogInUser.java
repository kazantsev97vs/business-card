package softlab.test.task.models;

import lombok.Data;

/**
 * Модель для входа в аккаунт
 */
@Data
public class LogInUser {

    private String login;

    private String password;
}