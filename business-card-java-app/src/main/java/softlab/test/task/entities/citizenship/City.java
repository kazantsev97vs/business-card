package softlab.test.task.entities.citizenship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.SpecificBaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Город
 */
@Entity
@Data
@NoArgsConstructor
public class City extends SpecificBaseEntity {

    /**
     * Страна, в к которой находится город
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private Country country;
    /**
     * У города мб свой список станций метро
     */
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<SubwayStation> subwayStationList;

    public City(String name, Country country) {
        super(name);
        this.country = country;
    }

    public City(String name, Country country, List<SubwayStation> subwayStationList) {
        super(name);
        this.country = country;
        this.subwayStationList = subwayStationList;
    }

    @Override
    public String toString() {
        return "City { "
                + super.toString()
                + ", country: " + country
                + ", subwayStationList: " + subwayStationList
                + " }";
    }
}