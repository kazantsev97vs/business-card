package softlab.test.task.entities.experience;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Опыт работы
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experience extends BaseEntity {
    /**
     * Дата начала работы
     */
    private Date dateBegin;

    /**
     * Дата окончания работы
     */
    private Date dateEnd;

    /**
     * Организация
     */
    private String organization;

    /**
     * Должность
     */
    @OneToOne
    private Position position;

    /**
     * Обязанности на рабочем месте
     */
    private String workplaceResponsibilities;
}