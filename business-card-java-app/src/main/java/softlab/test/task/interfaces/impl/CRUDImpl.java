package softlab.test.task.interfaces.impl;

import org.springframework.data.repository.CrudRepository;
import softlab.test.task.interfaces.CRUD;
import softlab.test.task.super_classes.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Базовая реализация основных CRUD методов над сущностью
 * @param <Entity> - тип сущности
 * @param <ID> - тип идентификатора сущности
 * @param <Repository> - тип репозитория сущности
 */
public abstract class CRUDImpl
        <Entity extends BaseEntity, ID, Repository extends CrudRepository<Entity, ID>> implements CRUD<Entity, ID> {

    protected Repository repository;

    public CRUDImpl(Repository repository) { this.repository = repository; }


    // Create ----------------------------------

    @Override
    public Entity save(Entity entity) {
        return repository.save(entity);
    }

    @Override
    public List<Entity> saveAll(List<Entity> entities) {

        List<Entity> list = new ArrayList<>();

        repository.saveAll(entities).forEach(list::add);

        return list;
    }


    // Read ------------------------------------

    @Override
    public Entity get(ID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public List<Entity> getAll() {

        List<Entity> list = new ArrayList<>();

        repository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public List<Entity> getAll(List<ID> ids) {

        List<Entity> list = new ArrayList<>();

        repository.findAllById(ids).forEach(list::add);

        return list;
    }

    @Override
    public Long count() {
        return repository.count();
    }


    // Update ----------------------------------

    @Override
    public Entity update(Entity entity) {
        return repository.save(entity);
    }


    // Delete ----------------------------------

    @Override
    public Boolean delete(ID id) {

        repository.deleteById(id);

        return !existsById(id);
    }

    @Override
    public Boolean delete(Entity entity) {

        repository.delete(entity);

        return !existsById((ID) entity.getId());
    }

    @Override
    public Boolean deleteAll(List<Entity> entities) {

        List<ID> ids = new ArrayList<>();

        for (Entity entity : entities) ids.add((ID) entity.getId());

        repository.deleteAll(entities);

        return getAll(ids).size() == 0;
    }

    @Override
    public Boolean deleteAll() {

        repository.deleteAll();

        return count() == 0;
    }
}