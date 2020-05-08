package softlab.test.task.entities.experience;

import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.SpecificBaseEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Профессиональная область
 */
@Entity
@Data
@NoArgsConstructor
public class ProfessionalArea extends SpecificBaseEntity {

    /**
     * Список вариантов навыков, которые могут быть у пользователя в текущей профессиональной области
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Skill> skills;

    /**
     * Список вариантов должностей, которые могут быть у пользователя в текущей профессиональной области
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Position> positions;

    public ProfessionalArea(String name, List<Skill> skills, List<Position> positions) {
        super(name);
        this.skills = skills;
        this.positions = positions;
    }

    public ProfessionalArea(String name) {
        super(name);
    }
}