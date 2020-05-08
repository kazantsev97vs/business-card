package softlab.test.task.entities.education;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softlab.test.task.super_classes.SpecificBaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Факультет
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faculty extends SpecificBaseEntity {

    @ManyToMany
    private List<Specialization> specializations;

    public Faculty(String name) {
        super(name);
    }
}