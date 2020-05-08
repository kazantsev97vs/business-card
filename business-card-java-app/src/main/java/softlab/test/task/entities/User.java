package softlab.test.task.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import softlab.test.task.enums.Gender;
import softlab.test.task.super_classes.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class User extends BaseEntity {

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String login;

    private String password;

    private String email;

    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER)
    private List<BusinessCard> businessCardList;

    /*
        параметр fetch = FetchType.EAGER говорит, что при загрузке владеемого объекта необходимо сразу загрузить и коллекцию владельцев.
        Стратегии загрузки (fetch) бывает две: EAGER и LAZY.
        В первом случае объекты коллекции сразу загружаются в память, они будут находиться там полностью загруженные и готовые к употреблению объекты.
        во втором случае только при обращении к ним.
        FetchType.LAZY загружает объекты только по мере обращения, но при этом требует, чтобы соединение с базой (или транзакция) сохранялись.
     */

    public User(String firstName, String lastName, String login, String password, String email, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User { "
                + super.toString()
                + ", firstName: '" + firstName
                + "', lastName: '" + lastName
                + "', login: '" + login
                + "', password: '" + password
                + "', email: '" + email
                + "', gender: " + gender
                + "', businessCardList: " + businessCardList
                + "' }";
    }
}