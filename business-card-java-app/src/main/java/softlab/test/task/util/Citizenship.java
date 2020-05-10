package softlab.test.task.util;

import softlab.test.task.entities.citizenship.Country;

import java.io.IOException;
import java.util.List;


public class Citizenship {

    public static List<Country> fillCitizenship() throws IOException {

        List<Country> countryList = OstranahParser.getAllWorldCountries();

        for (Country country : countryList) country.setCityList(PlanetologParser.getCountryCities(country));

        return countryList;
    }
}
