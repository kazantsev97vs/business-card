package softlab.test.task.entities.education;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Образование
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education extends BaseEntity {
    /**
     * Уровень
     */
    @OneToOne
    private EducationLevel level;

    /**
     * Учебное заведение
     */
    @OneToOne
    private EducationalInstitution institution;

    /**
     * Специализация
     */
    @OneToOne
    private Specialization specialization;

    /**
     * Год окончания
     */
    private Date dateEnd;
}