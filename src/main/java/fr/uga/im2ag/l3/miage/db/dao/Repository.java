package fr.uga.im2ag.l3.miage.db.dao;

import java.util.List;

/**
 * A base repository contract for CRUD operations on entities.
 * @param <T> the entity type
 * @param <I> the id type
 */
public interface Repository<T, I> {

    /**
     * Save or update an entity.
     * @param entity the entity to save
     */
    void save(T entity);

    /**
     * Delete an entity.
     * @param entityClass class of the entity to remove
     * @param id id of the entity to remove
     */
    void  delete(Class<T> entityClass, I id);

    /**
     * Retrieve an entity by id.
     * @param entityClass class of the entity to retrieve
     * @param id id of the entity to remove
     * @return the entity of null
     */
    T get(Class<T> entityClass, I id);

    /**
     * Retrieve all entities of a given type.
     * @param entityClass class of the entity to retrieve
     * @return all entities of a given type or an empty collection
     */
    List<T> getAll(Class<T> entityClass);

}
