package softlab.test.task.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import softlab.test.task.entities.citizenship.Language;

import java.util.Random;

@SpringBootTest
public class LanguageServiceCRUDTest {

    @Autowired
    private LanguageService languageService;

    private static Long id;

    private static final Random random = new Random();

    @Test
    public void shouldLanguageExistsAfterSaving() {

        Language language = new Language("English");

        Language savedLanguage = languageService.save(language);

        Assert.notNull(savedLanguage, "Language is not saved!");
    }

    @Test
    public void shouldLanguageChangedAfterUpdating() {


    }

    @Test
    public void shouldLanguageNotExistsAfterDeleting() {


    }
}