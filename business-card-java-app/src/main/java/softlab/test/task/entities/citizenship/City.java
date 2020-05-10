package softlab.test.task.entities.citizenship;

import lombok.*;
import softlab.test.task.super_classes.SpecificBaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Город
 */
@Entity
@Setter @Getter
@NoArgsConstructor
public class City extends SpecificBaseEntity {

    /**
     * У города мб свой список станций метро
     */
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<SubwayStation> subwayStationList;

    public City(String name, List<SubwayStation> subwayStationList) {
        super(name);
        this.subwayStationList = subwayStationList;
    }

    public City(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "City { "
                + super.toString()
                + ", subwayStationList: " + subwayStationList
                + " }";
    }
}