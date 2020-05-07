package softlab.test.task.interfaces;

import softlab.test.task.super_classes.BaseEntity;

import java.util.List;

/**
 * Create Read Update Delete
 * - основные CRUD методы над сущностью
 *
 * @param <Entity> - тип сущности
 * @param <ID>     - тип идентификатора сущности
 */
public interface CRUD <Entity extends BaseEntity, ID> {

    // Create ----------------------------------

    Entity save(Entity entity);

    List<Entity> saveAll(List<Entity> entities);


    // Read ------------------------------------

    Entity get(ID id);

    Boolean existsById(ID id);

    List<Entity> getAll();

    List<Entity> getAll(List<ID> ids);

    Long count();


    // Update ----------------------------------

    Entity update(Entity entity);


    // Delete ----------------------------------

    Boolean delete(ID id);

    Boolean delete(Entity entity);

    Boolean deleteAll(List<Entity> entities);

    Boolean deleteAll();

}