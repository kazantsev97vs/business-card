package softlab.test.task.entities.citizenship;

import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.SpecificBaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Страна
 */
@Entity
@Data
@NoArgsConstructor
public class Country extends SpecificBaseEntity {

    /**
     * Кодировка ISO 3166-1 alpha-2 страны (код IATA) (у России, например, RU)
     */
    private String code;

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

    public Country(String name, String code, String region, String capital, List<Language> officialLanguages) {
        super(name);
        this.code = code;
        this.region = region;
        this.capital = capital;
        this.officialLanguages = officialLanguages;
    }

    public Country(String name, String code, String region, String capital, List<Language> officialLanguages, List<City> cityList) {
        super(name);
        this.code = code;
        this.region = region;
        this.capital = capital;
        this.officialLanguages = officialLanguages;
        this.cityList = cityList;
    }

    @Override
    public String toString() {
        return "Country { "
                + super.toString()
                + ", code: '" + code
                + "', region: '" + region
                + "', capital: '" + capital
                + "', officialLanguages: " + officialLanguages
                + ", cityList: " + cityList
                + " }";
    }
}