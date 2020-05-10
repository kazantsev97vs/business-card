package softlab.test.task.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import softlab.test.task.entities.citizenship.City;
import softlab.test.task.entities.citizenship.Country;
import softlab.test.task.entities.citizenship.Language;
import softlab.test.task.services.CountryService;
import softlab.test.task.services.LanguageService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@SpringBootTest
public class CitizenshipTest {

    @Autowired
    private CountryService countryService;

    @Autowired
    private LanguageService languageService;

    @Test
    public void shouldCitizenshipTablesBeFillingAfterFillCitizenship() {

        try {
            List<Country> countries = Citizenship.fillCitizenship();

            Set<String> languagesNames = new TreeSet<>();
            List<Language> languageList = new ArrayList<>();

            for (Country country : countries) {
                List<Language> countryLanguageList = country.getOfficialLanguages();

                for (Language language : countryLanguageList) languagesNames.add(language.getName());
            }

            for (String name: languagesNames) languageList.add(new Language(name));

            languageService.saveAll(languageList);

            for (Country country : countries) {

                List<Language> countryLanguageList = country.getOfficialLanguages();
                for (Language language: countryLanguageList) language.setId(languageService.getByName(language.getName()).getId());

            }

            List<Country> savedCountries = countryService.saveAll(countries);

            assert null != savedCountries;

            assert countries.size() == savedCountries.size();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}