package softlab.test.task.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import softlab.test.task.entities.User;
import softlab.test.task.enums.Gender;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void shouldUserExistsAfterItsSaving() {

        int count = userService.getAll().size();

        User user = new User("firstNameTest",
                "lastNameTest",
                "loginTest",
                "passwordTest",
                "emailTest@email.com",
                Gender.MALE);


        User savedUser = userService.save(user);

        assert savedUser != null;

        assert count < userService.getAll().size();
    }
}