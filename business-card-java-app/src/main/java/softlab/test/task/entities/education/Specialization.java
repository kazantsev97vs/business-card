package softlab.test.task.entities.education;

import lombok.Data;
import softlab.test.task.super_classes.SpecificBaseEntity;

import javax.persistence.Entity;

/**
 * Специализация
 */
@Entity
@Data
public class Specialization extends SpecificBaseEntity {

    public Specialization(String name) {
        super(name);
    }
}