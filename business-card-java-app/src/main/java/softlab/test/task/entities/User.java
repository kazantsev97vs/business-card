package softlab.test.task.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.enums.Gender;
import softlab.test.task.super_classes.BaseEntity;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    private String firstName;

    private String lastName;

    private String login;

    private String password;

    private String email;

    private Gender gender;

    @Override
    public String toString() {
        return  "{ " + super.toString()
                + ", firstName: '" + firstName + '\''
                + ", lastName: '" + lastName + '\''
                + ", login: '" + login + '\''
                + ", password: '" + password + '\''
                + ", email: '" + email + '\''
                + ", gender: " + gender
                + " }";
    }
}