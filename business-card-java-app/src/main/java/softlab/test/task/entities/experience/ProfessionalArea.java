package softlab.test.task.entities.experience;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.SpecificBaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Профессиональная область
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionalArea extends SpecificBaseEntity {

    /**
     * Список вариантов навыков, которые могут быть у пользователя в текущей профессиональной области
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Skill> skills;

    /**
     * Список вариантов должностей, которые могут быть у пользователя в текущей профессиональной области
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Position> positions;

    public ProfessionalArea(String name, List<Position> positions) {
        super(name);
        this.positions = positions;
    }

    public ProfessionalArea(String name, List<Skill> skills, List<Position> positions) {
        super(name);
        this.skills = skills;
        this.positions = positions;
    }

    public ProfessionalArea(String name) {
        super(name);
    }
}