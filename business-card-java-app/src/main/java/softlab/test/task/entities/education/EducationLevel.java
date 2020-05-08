package softlab.test.task.entities.education;

import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.SpecificBaseEntity;
import javax.persistence.Entity;

/**
 * Уровень образования
 */
@Entity
@Data
@NoArgsConstructor
public class EducationLevel extends SpecificBaseEntity {

    public EducationLevel(String name) {
        super(name);
    }
}