package softlab.test.task.entities.citizenship;

import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.SpecificBaseEntity;
import javax.persistence.Entity;

/**
 * Язык
 */
@Entity
@NoArgsConstructor
public class Language extends SpecificBaseEntity {

    public Language(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Language { " + super.toString() + " }";
    }
}