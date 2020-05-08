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
     * У страны есть список официальных языков (мб один), на которых говорят граждане
     */
    @ManyToMany
    private List<Language> languageList;

    /**
     * У страны есть список городов, которые ей принаждлежат
     */
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<City> cityList;

    public Country(String name) {
        super(name);
    }

    public Country(String name, List<Language> languageList) {
        super(name);
        this.languageList = languageList;
    }

    public Country(String name, List<Language> languageList, List<City> cityList) {
        super(name);
        this.languageList = languageList;
        this.cityList = cityList;
    }
}