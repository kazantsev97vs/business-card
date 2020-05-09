package softlab.test.task.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import softlab.test.task.entities.citizenship.Country;
import softlab.test.task.entities.citizenship.Language;

import java.io.IOException;
import java.util.*;

/**
 * Географический справочник
 * «О странах»
 * href: http://ostranah.ru/
 */
public class OstranahParser {

    public final static String href = "http://ostranah.ru/";

    public static List<String> keys = new LinkedList<>();

    private final static String region = "Регион";
    private final static String capital = "Столица";
    private final static String officialLanguages = "Официальн[а-я]+ язык[а-я]*";
    private final static String fullName = "Полное название";

    static {
        keys.add(region);
        keys.add(capital);
        keys.add(officialLanguages);
        keys.add(fullName);
    }

    public static Map<String, String> getAllWorldCountriesNamesAndHrefs() throws IOException {

        Document ostranahDoc = Jsoup.connect(href).get();

        Element allCountriesElement = ostranahDoc.getElementsByClass("allcountries").get(0);
        Elements ulElements = allCountriesElement.getElementsByTag("ul");

        Map<String, String> countries = new LinkedHashMap<>();

        for (Element ul : ulElements) {
            Elements liElements = ul.getElementsByTag("li");

            for (Element li : liElements) {
                Element a = li.getElementsByTag("a").get(0);
                String href = a.attr("href");
                String country = a.text();
                countries.put(country, href);
            }
        }

        return countries;
    }

    public static Map<String, String> getCountryInfo (String countryHref) throws IOException {
        Document ostranahCountryDoc = Jsoup.connect(href + countryHref).get();

        Element infoElement = ostranahCountryDoc.getElementsByClass("info").get(0);
        Elements dtElements = infoElement.getElementsByTag("dt");
        Elements ddElements = infoElement.getElementsByTag("dd");

        Map<String, String> info = new HashMap<>();

        List<String> keysList = new LinkedList<>(keys);

        for (int i = 0; i < dtElements.size() && keysList.size() > 0; i++) {
            String text = dtElements.get(i).text();

            for (int j = 0; j < keysList.size(); j++) {
                String key = keysList.get(j);

                if (text.matches(key)) {

                    String value = ddElements.get(i).text();
                    info.put(text, value);
                    keysList.remove(j);
                    break;
                }
            }
        }

        return info;
    }


    public static List<Country> getAllWorldCountries() throws IOException {

        List<Country> countryList = new ArrayList<>();

        Map<String, String> allWorldCountriesNamesAndHrefs = OstranahParser.getAllWorldCountriesNamesAndHrefs();

        for (Map.Entry<String, String> entry : allWorldCountriesNamesAndHrefs.entrySet()) {

            Map<String, String> countryInfo = getCountryInfo(entry.getValue());

            String countryName = countryInfo.get(fullName) == null ? countryInfo.get(region) : countryInfo.get(fullName);

            String countryRegion = countryInfo.get(region);

            String countryCapital = countryInfo.get(capital);

            List<Language> countryOfficialLanguages = new ArrayList<>();
            String someOfficialLanguage = "Официальный язык";
            String anyOfficialLanguages = "Официальные языки";

            List<String> languages = new ArrayList<>();
            if (countryInfo.get(someOfficialLanguage) != null) {
                languages.add(countryInfo.get(someOfficialLanguage));
            }

            if (countryInfo.get(anyOfficialLanguages) != null) {
                languages = Arrays.asList(countryInfo.get(anyOfficialLanguages).split(", "));
            }

            for (String language : languages) {
                countryOfficialLanguages.add(new Language(language));
            }

            Country country = new Country(
                    countryName,
                    countryRegion,
                    countryCapital,
                    countryOfficialLanguages
            );

            countryList.add(country);
        }

        return countryList;
    }

    public static void main(String[] args) {


        try {
            List<Country> countries = getAllWorldCountries();
            System.out.println(countries);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
