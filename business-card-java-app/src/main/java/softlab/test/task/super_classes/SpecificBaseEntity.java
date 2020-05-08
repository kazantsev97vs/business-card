package softlab.test.task.super_classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

/**
 * Каждая определенная сущность должна иметь свой идентификатор id, а также название
 */
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class SpecificBaseEntity extends BaseEntity {

    /**
     * Название сущности
     */
    private String name;
}