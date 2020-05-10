package softlab.test.task.entities.citizenship;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softlab.test.task.super_classes.SpecificBaseEntity;

import javax.persistence.Entity;

/**
 * Станция метро
 */
@Entity
@Setter @Getter
@NoArgsConstructor
public class SubwayStation extends SpecificBaseEntity {

    public SubwayStation(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "SubwayStation { "
                + super.toString()
                + " }";
    }
}