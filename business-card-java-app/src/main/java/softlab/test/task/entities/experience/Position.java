package softlab.test.task.entities.experience;

import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.SpecificBaseEntity;
import javax.persistence.Entity;

/**
 * Должность
 */
@Entity
@NoArgsConstructor
public class Position extends SpecificBaseEntity {

    public Position(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Position { " + super.toString() + " }";
    }
}