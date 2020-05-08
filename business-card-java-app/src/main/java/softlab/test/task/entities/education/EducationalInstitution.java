package softlab.test.task.entities.education;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.SpecificBaseEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Учебное заведение
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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