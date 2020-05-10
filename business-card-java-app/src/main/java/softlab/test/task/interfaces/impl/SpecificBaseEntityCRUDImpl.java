package softlab.test.task.interfaces.impl;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import softlab.test.task.interfaces.SpecificBaseEntityCRUD;
import softlab.test.task.super_classes.SpecificBaseEntity;
import java.util.List;

/**
 * Базовая реализация основных CRUD методов над сущностью
 * + методов реализующих поиск по имени
 * param <Entity> - тип сущности, содержащий поля "name" и "id"
 * param <ID> - тип идентификатора сущности
 * param <Repository> - тип репозитория сущности, наследующийся от CrudRepository и содержащий методы поиска по имени
 */
public abstract class SpecificBaseEntityCRUDImpl
        <Entity extends SpecificBaseEntity, ID, Repository extends CrudRepository<Entity, ID> & SpecificBaseEntityCRUD<Entity>>
        extends LoggingCRUDImpl <Entity, ID, Repository>
        implements SpecificBaseEntityCRUD<Entity> {

    public SpecificBaseEntityCRUDImpl(Repository repository) {
        super(repository);
    }


    // Create ----------------------------------

    @Override
    public Entity save(Entity entity) {

        if (repository.getByName(entity.getName()) != null) {
            logger.error(entity.getClass().getSimpleName() + " is already exists with name = " + entity.getName() + " and NOT SAVED");
            return null;
        }

        return super.save(entity);
    }

    @Override
    public List<Entity> saveAll(List<Entity> entities) {

        for (Entity entity : entities) {
            if (repository.getByName(entity.getName()) != null) {
                String entityName = entity.getClass().getSimpleName();
                logger.error(entityName + " is already exists with name = " + entity.getName() + " and ALL " + entityName + "s are NOT SAVED");
                return null;
            }
        }
        return super.saveAll(entities);
    }

    // Read ------------------------------------

    @Override
    public Entity getByName(String name) {
        return repository.getByName(name);
    }

    @Override
    public List<Entity> getAllByName(String name) {
        return repository.getAllByName(name);
    }

    @Override
    public List<Entity> getAllByName(String name, Pageable page) {
        return repository.getAllByName(name, page);
    }
}