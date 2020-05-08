package softlab.test.task.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import softlab.test.task.entities.User;
import softlab.test.task.enums.Gender;

import java.util.Random;

@SpringBootTest
public class UserServiceCRUDTest {

    @Autowired
    private UserService userService;

    private static Long id;

    private static final Random random = new Random();

    @Test
    public void shouldUserExistsAfterSaving() {

        long count = userService.count();

        User user = new User("firstNameTest",
                "lastNameTest",
                "loginTest" + random.nextInt(),
                "passwordTest",
                "emailTest@email.com",
                Gender.MALE);


        User savedUser = userService.save(user);

        assert savedUser != null;

        id = savedUser.getId();

        assert userService.get(savedUser.getId()) != null;

        assert count < userService.count();
    }

    @Test
    public void shouldUserChangedAfterUpdating() {

        shouldUserExistsAfterSaving();

        User user = userService.get(id);

        assert user != null;

        User newUser = new User(user.getFirstName() + "Updated",
                user.getLastName() + "Updated",
                user.getLogin() + "Updated",
                user.getPassword() + "Updated",
                user.getEmail() + "Updated",
                Gender.FEMALE);

        newUser.setId(id);

        User updatedUser = userService.update(newUser);

        assert !user.equals(updatedUser);

        shouldUserNotExistsAfterDeleting();
    }

    @Test
    public void shouldUserNotExistsAfterDeleting() {

        if (id == null) shouldUserExistsAfterSaving();

        long count = userService.count();

        assert userService.get(id) != null;

        boolean isDeleted = userService.delete(id);

        assert isDeleted;

        assert userService.get(id) == null;

        id = null;

        assert count > userService.count();
    }
}