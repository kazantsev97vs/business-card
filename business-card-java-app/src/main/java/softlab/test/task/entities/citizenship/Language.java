package softlab.test.task.entities.citizenship;

import lombok.Data;
import softlab.test.task.super_classes.SpecificBaseEntity;
import javax.persistence.Entity;

/**
 * Язык
 */
@Entity
@Data
public class Language extends SpecificBaseEntity {
    public Language(String name) {
        super(name);
    }
}