package softlab.test.task.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import softlab.test.task.entities.BusinessCard;
import softlab.test.task.entities.User;
import softlab.test.task.entities.citizenship.City;
import softlab.test.task.entities.citizenship.Country;
import softlab.test.task.entities.citizenship.Language;
import softlab.test.task.entities.experience.Position;
import softlab.test.task.entities.experience.ProfessionalArea;
import softlab.test.task.entities.experience.Skill;
import softlab.test.task.enums.Gender;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class BusinessCardServiceCRUDTest {

    @Autowired
    private BusinessCardService businessCardService;

    @Autowired
    private UserService userService;

    @Test
    public void shouldLanguageExistsAfterSaving() {

        User user = userService.save(new User("firstNameTest",
                "lastNameTest",
                "loginTest",
                "passwordTest",
                "emailTest@email.com",
                Gender.MALE));

        Assert.notNull(user, "User is null");

        City city = new City("Новосибирск");
        List<City> cities = new ArrayList<>();
        cities.add(city);

        Date birthday = new Date();

        Country russia = new Country("Russia");
        russia.setCityList(cities);
//        russia.setLanguageList();

        List<Country> citizenship = new ArrayList<>();
        citizenship.add(russia);

        ProfessionalArea professionalArea = new ProfessionalArea("IT");

        Skill skill = new Skill("Java", professionalArea);
        List<Skill> skills = new ArrayList<>();
        skills.add(skill);

        Position careerObjective = new Position("Java developer");

        Double salary = 100_000.0;

        List<ProfessionalArea> professionalAreaList = new ArrayList<>();
        professionalAreaList.add(professionalArea);

        Language russianLanguage = new Language("Русский язык");
        List<Language> foreignLanguages = new ArrayList<>();
        foreignLanguages.add(new Language("English"));

        BusinessCard testBusinessCard = new BusinessCard(
                user,
                user.getFirstName(),
                user.getLastName(),
                city,
                birthday,
                Gender.MALE,
                citizenship,
                false,
                null,
                "About test user",
                skills,
                careerObjective,
                salary,
                professionalAreaList,
                null,
                russianLanguage,
                foreignLanguages,
                null
        );

        System.out.println(testBusinessCard);

        BusinessCard savedBusinessCard = businessCardService.save(testBusinessCard);

        Assert.notNull(savedBusinessCard, "savedBusinessCard is null!");

        assert businessCardService.get(savedBusinessCard.getId()) != null;
    }
}
