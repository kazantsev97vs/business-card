package softlab.test.task.super_classes;

import lombok.Getter;
import lombok.Setter;

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
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Override
    public String toString() {
        return "id: " + id;
    }
}