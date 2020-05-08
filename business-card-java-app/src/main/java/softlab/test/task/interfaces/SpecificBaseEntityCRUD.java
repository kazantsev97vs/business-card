package softlab.test.task.interfaces;

import org.springframework.data.domain.Pageable;
import softlab.test.task.super_classes.SpecificBaseEntity;
import java.util.List;

/**
 * Create Read Update Delete
 * - основные CRUD методы над сущностью
 * + поиск по имени
 * @param <Entity> - тип сущности, содержащий поля "name" и "id"
 */
public interface SpecificBaseEntityCRUD <Entity extends SpecificBaseEntity> {

    // Read ------------------------------------

    Entity getByName(String name);

    List<Entity> getAllByName(String name);

    List<Entity> getAllByName(String name, Pageable page);
}