package softlab.test.task.entities.citizenship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.SpecificBaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Город
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City extends SpecificBaseEntity {

    /**
     * У города мб свой список станций метро
     */
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<SubwayStation> subwayStationList;

    public City(String name) {
        super(name);
    }

    public City(String name, List<SubwayStation> subwayStationList) {
        super(name);
        this.subwayStationList = subwayStationList;
    }
}