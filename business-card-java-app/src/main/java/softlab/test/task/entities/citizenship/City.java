package softlab.test.task.entities.citizenship;

import lombok.Data;
import softlab.test.task.super_classes.SpecificBaseEntity;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Город
 */
@Entity
@Data
public class City extends SpecificBaseEntity {

    /**
     * У города мб свой список станций метро
     */
    @OneToMany
    private List<SubwayStation> subwayStationList;

    public City(String name) {
        super(name);
    }

    public City(String name, List<SubwayStation> subwayStationList) {
        super(name);
        this.subwayStationList = subwayStationList;
    }
}