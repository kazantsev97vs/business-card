package softlab.test.task.interfaces.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.repository.CrudRepository;
import softlab.test.task.super_classes.BaseEntity;

import java.util.List;

/**
 * Базовая реализация основных CRUD методов над сущностью логгирующая все изменения
 *
 * @param <Entity>     - тип сущности
 * @param <ID>         - тип идентификатора сущности
 * @param <Repository> - тип репозитория сущности
 */
public abstract class LoggingCRUDImpl
        <Entity extends BaseEntity, ID, Repository extends CrudRepository<Entity, ID>>
        extends CRUDImpl<Entity, ID, Repository> {

    public LoggingCRUDImpl(Repository repository) { super(repository); }

    private static final Logger logger = LogManager.getLogger(LoggingCRUDImpl.class);


    // Create ----------------------------------

    @Override
    public Entity save(Entity entity) {

        Entity savedEntity = super.save(entity);

        logger.info(entity.getClass().getSimpleName() + " is saved", savedEntity);

        return savedEntity;
    }

    @Override
    public List<Entity> saveAll(List<Entity> entities) {

        List<Entity> entityList = super.saveAll(entities);

        for (Entity entity : entityList) {
            logger.info(entity.getClass().getSimpleName() + " is saved", entity);
        }

        return entityList;
    }


    // Read ------------------------------------


    // Update ----------------------------------

    @Override
    public Entity update(Entity entity) {

        Entity updatedEntity = super.update(entity);

        logger.info(entity.getClass().getSimpleName() + " is updated", updatedEntity);

        return updatedEntity;
    }


    // Delete ----------------------------------

    @Override
    public Boolean delete(ID id) {

        Entity entity = get(id);

        Boolean isDeleted = super.delete(id);

        logger.info(entity.getClass().getSimpleName() + " is " + (isDeleted ? null : "not") + " deleted", entity);

        return isDeleted;
    }

    @Override
    public Boolean delete(Entity entity) {

        Boolean isDeleted = super.delete(entity);

        logger.info(entity.getClass().getSimpleName() + " is " + (isDeleted ? null : "not") + " deleted", entity);

        return isDeleted;
    }

    @Override
    public Boolean deleteAll(List<Entity> entities) {

        Boolean isDeleted = super.deleteAll(entities);

        for (Entity entity : entities) {
            logger.info(entity.getClass().getSimpleName() + " is " + (isDeleted ? null : "not") + " deleted", entity);
        }

        return isDeleted;
    }

    @Override
    public Boolean deleteAll() {

        Boolean isDeleted = super.deleteAll();

        logger.info("All rows is " + (isDeleted ? null : "not") + " deleted");

        return isDeleted;
    }
}