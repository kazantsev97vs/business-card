package softlab.test.task.entities.experience;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.SpecificBaseEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Должность
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position extends SpecificBaseEntity {

    /**
     * Профессиональная область к которой относится должность
     */
    @ManyToOne(optional = false)
    private ProfessionalArea professionalArea;

    public Position(String name, ProfessionalArea professionalArea) {
        super(name);
        this.professionalArea = professionalArea;
    }
}