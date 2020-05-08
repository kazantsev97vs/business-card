package softlab.test.task.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.entities.citizenship.City;
import softlab.test.task.entities.citizenship.Country;
import softlab.test.task.entities.citizenship.Language;
import softlab.test.task.entities.education.Education;
import softlab.test.task.entities.experience.Experience;
import softlab.test.task.entities.experience.Position;
import softlab.test.task.entities.experience.ProfessionalArea;
import softlab.test.task.entities.experience.Skill;
import softlab.test.task.entities.other_important_information.OtherImportantInformation;
import softlab.test.task.enums.Gender;
import softlab.test.task.super_classes.SpecificBaseEntity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 *  Контактные данные - имя
 *                      фамилия
 *                      город проживания
 *
 *  Основная информация - Дата рождения
 *                        пол
 *                        гражданство
 *                        опыт работы (да, нет)
 *
 *  Специальность - Желаемая должность
 *                  Зарплата
 *                  Профессиональная область
 *
 *  Опыт работы -   Начало работы
 *                  Окончание
 *                  Организация
 *                  Должность
 *                  Обязанности на рабочем месте
 *                  О себе
 *                  Ключевые навыки
 *
 *  Образование -   Уровень ( если выше среднего, то добавляются поля ниже )
 *                  Учебное заведение
 *                  Факультет
 *                  Специализация
 *                  Год окончания
 *
 *  Владение языками    -   Родной язык
 *                          Иностранные языки
 *
 *  Другая важная информация:   Наличие автомобиля  да/нет
 *                              Категория прав
 *                              Разрешение на работу
 *                              Переезд
 *                              Занятость
 *                              График работы
 *                              Станция метро
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessCard extends SpecificBaseEntity {
    // параметр optional говорит JPA, является ли значение в этом поле обязательным или нет
    // параметр cascade говорит JPA, что делать с владеемыми объектами при операциях над владельцем.
    // аннотация @JoinColumn задаёт имя столбца, в котором будет храниться ссылка на владеемый объект
    @ManyToOne(optional = false)
    @NotNull
    private User user;

    /*
        Контактные данные ----------------------
     */

    private String firstName;

    private String lastName;

    @OneToOne
    private City currentCity; // город проживания

    /*
        Основная информация --------------------
     */

    private Date birthday;              // дата рождения

    private Gender gender;              // пол

    @ManyToMany
    private List<Country> citizenship; // гражданство

    /*
        Опыт работы ----------------------------
     */

    private Boolean experience;             // опыт работы - есть, нету

    @OneToMany
    private List<Experience> experienceList;


    private String aboutMyself; // О себе

    @ManyToMany
    private List<Skill> skills; // Ключевые навыки

    /*
        Специальность --------------------------
     */

    @OneToOne
    private Position careerObjective;                   // желаемая должность

    private Double salary;                              // зарплата

    @OneToMany
    private List<ProfessionalArea> professionalArea;    // профессиональная область

    /*
        Образование ----------------------------
     */

    @OneToMany
    private List<Education> educationList;

    /*
        Владение языками -----------------------
     */

    @OneToOne
    private Language nativeLanguage;            // родной язык

    @OneToMany
    private List<Language> foreignLanguages;    // иностранные языки

    /*
        Другая важная информация
     */

    @OneToOne
    private OtherImportantInformation otherImportantInformation;
}