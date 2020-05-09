package softlab.test.task.entities.citizenship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.SpecificBaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Страна
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country extends SpecificBaseEntity {

    /**
     * Регион
     */
    private String region;

    /**
     * Столица
     */
    private String capital;

    /**
     * У страны есть список официальных языков (мб один), на которых говорят граждане
     */
    @ManyToMany
    private List<Language> officialLanguages;

    /**
     * У страны есть список городов, которые ей принаждлежат
     */
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<City> cityList;

    public Country(String name) {
        super(name);
    }

    public Country(String name, String region, String capital, List<Language> officialLanguages) {
        super(name);
        this.region = region;
        this.capital = capital;
        this.officialLanguages = officialLanguages;
    }
}