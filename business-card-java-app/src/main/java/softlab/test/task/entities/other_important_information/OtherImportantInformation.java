package softlab.test.task.entities.other_important_information;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.entities.citizenship.SubwayStation;
import softlab.test.task.enums.DriverLicenseCategory;
import softlab.test.task.enums.Employment;
import softlab.test.task.enums.Moving;
import softlab.test.task.enums.WorkSchedule;
import softlab.test.task.super_classes.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Другая важная информация
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtherImportantInformation extends BaseEntity {

    /**
     * Наличие автомобиля  да/нет
     */
    private Boolean carAvailability;

    /**
     * Категория водительских прав
     */
    private DriverLicenseCategory driverLicenseCategory;

    /**
     * Станция метро
     */
    @OneToOne
    private SubwayStation subwayStation;

    /**
     * Переезд
     */
    private Moving moving;

    /**
     * Занятость
     */
    private Employment employment;

    /**
     * График работы
     */
    private WorkSchedule workSchedule;
}