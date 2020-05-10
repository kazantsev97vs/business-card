package softlab.test.task.super_classes;

import lombok.*;

import javax.persistence.MappedSuperclass;

/**
 * Каждая определенная сущность должна иметь свой идентификатор id, а также название
 */
@MappedSuperclass
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class SpecificBaseEntity extends BaseEntity {

    /**
     * Название сущности
     */
    private String name;

    @Override
    public String toString() {
        return super.toString() + ", name: '" + name + "'";
    }
}