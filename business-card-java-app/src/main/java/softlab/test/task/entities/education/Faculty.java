package softlab.test.task.entities.education;

import lombok.Data;
import softlab.test.task.super_classes.SpecificBaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Факультет
 */
@Entity
@Data
public class Faculty extends SpecificBaseEntity {

    @ManyToMany
    private List<Specialization> specializations;

    public Faculty(String name) {
        super(name);
    }
}