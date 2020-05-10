package softlab.test.task.super_classes;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Каждая сущность должна иметь свой идентификатор id
 */
@MappedSuperclass
@Setter @Getter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Long id;

    @Override
    public String toString() {
        return "id: " + id;
    }
}