package softlab.test.task.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import softlab.test.task.entities.experience.Position;
import softlab.test.task.entities.experience.ProfessionalArea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * HeadHunter - сервис, который помогает найти работу и подобрать персонал
 * href: https://hh.ru/
 */
public class HHruParser {

    public final static String href = "https://hh.ru";

    public static Map<String, String> getProfessions() throws IOException {
        Map<String, String> professions = new LinkedHashMap<>();

        Document catalog = Jsoup.connect(href + "/catalog").get();

        Elements catalogElements = catalog.getElementsByClass("catalog__item-link");

        for (Element element : catalogElements) {
            String professionName = element.text();
            String professionHref = element.attr("href");
            professions.put(professionName, professionHref);
        }

        return professions;
    }

    public static List<String> getProfessionPositions(String href) throws IOException {
        List<String> positions = new ArrayList<>();

        Document catalogProf = Jsoup.connect(HHruParser.href + href).get();

        Element ulElement = catalogProf.getElementsByClass("multiple-column-list Bloko-Tabs-Body g-hidden").get(0);

        Elements liElements = ulElement.getElementsByClass("catalog__item-link");

        for (Element li : liElements) positions.add(li.text());

        return positions;
    }
}