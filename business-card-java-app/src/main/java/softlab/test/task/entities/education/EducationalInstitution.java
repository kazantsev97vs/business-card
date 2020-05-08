package softlab.test.task.entities.education;

import lombok.Data;
import softlab.test.task.super_classes.SpecificBaseEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Учебное заведение
 */
@Entity
@Data
public class EducationalInstitution extends SpecificBaseEntity {

    /**
     * У учебного заведения есть факультеты
     */
    @ManyToMany
    private List<Faculty> faculties;

    public EducationalInstitution(String name) {
        super(name);
    }
}