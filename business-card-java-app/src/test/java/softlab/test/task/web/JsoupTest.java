package softlab.test.task.web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class JsoupTest {

    @Test
    public void shouldJsoupLoadData() {
        try {
            Document document = Jsoup.connect("https://www.google.com/search?q=Russia").get();
            Element body = document.body();

            System.out.println(document.title());



        } catch (IOException e) {
            System.out.println("Can not to connect");
            e.printStackTrace();
        }
    }
}


/*
String google = "https://www.google.com/";
String officialCountryLanguages = "http://ostranah.ru/_lists/languages.php";
Document content = Jsoup.connect(officialCountryLanguages).get();
Element body = content.body();
String tableId = "sort-table";
Element table = body.getElementById(tableId);
Element tbody = table.getElementsByTag("tbody").get(0);
Elements trs = tbody.getElementsByTag("tr");
Map<String, List<String>> countries = new LinkedHashMap<>();

for (Element element : trs) {

    Elements tds = trs.get(0).getElementsByTag("td");
    List<String> languages = new ArrayList<>();

}
 */