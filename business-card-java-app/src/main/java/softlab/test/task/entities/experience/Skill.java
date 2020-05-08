package softlab.test.task.entities.experience;

import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.SpecificBaseEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Ключевые навыки
 */
@Entity
@Data
@NoArgsConstructor
public class Skill extends SpecificBaseEntity {

    /**
     * Профессиональная область к которой относится навык
     */
    @ManyToOne
    private ProfessionalArea professionalArea;

    public Skill(String name, ProfessionalArea professionalArea) {
        super(name);
        this.professionalArea = professionalArea;
    }
}