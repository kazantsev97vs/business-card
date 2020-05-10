package softlab.test.task.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import softlab.test.task.entities.citizenship.City;
import softlab.test.task.entities.citizenship.Country;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Справочник «Planetolog»
 * href: http://planetolog.ru/
 */
public class PlanetologParser {

    public final static String planetologHref = "http://planetolog.ru/";

    public static List<City> getCountryCities(Country country) throws IOException {

        Document planetologCityCountryList = Jsoup.connect(planetologHref + "city-country-list.php?country=" + country.getCode()).get();

        List<City> cities = new ArrayList<>();

        Elements cityElementsList = planetologCityCountryList.body().getElementsByClass("CountryList");

        for (Element element : cityElementsList) {
            String city = element.text();

            if (city.matches("[а-яА-Яa-zA-Z]{2,}")) {
                cities.add(new City(city));

            } else {
                if (city.matches("[а-яА-Яa-zA-Z ]{2,}")) {
                    String[] list = city.split(" ");

                    for (String s : list) cities.add(new City(s));
                }
            }
        }

        return cities;
    }
}
