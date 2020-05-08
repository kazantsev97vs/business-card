package softlab.test.task.entities.education;

import lombok.Data;
import softlab.test.task.super_classes.SpecificBaseEntity;
import javax.persistence.Entity;

/**
 * Уровень образования
 */
@Entity
@Data
public class EducationLevel extends SpecificBaseEntity {

    public EducationLevel(String name) {
        super(name);
    }
}