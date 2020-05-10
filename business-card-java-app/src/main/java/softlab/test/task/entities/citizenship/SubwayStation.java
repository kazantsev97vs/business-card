package softlab.test.task.entities.citizenship;

import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.SpecificBaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Станция метро
 */
@Entity
@Data
@NoArgsConstructor
public class SubwayStation extends SpecificBaseEntity {

    /**
     * Город, к которому относится станция
     */
    @ManyToOne
    private City city;

    public SubwayStation(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "SubwayStation { "
                + super.toString()
                + ", city=" + city
                + " }";
    }
}