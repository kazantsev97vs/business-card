package softlab.test.task.entities.citizenship;

import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.SpecificBaseEntity;

import javax.persistence.Entity;

/**
 * Станция метро
 */
@Entity
@Data
@NoArgsConstructor
public class SubwayStation extends SpecificBaseEntity {

    public SubwayStation(String name) {
        super(name);
    }
}