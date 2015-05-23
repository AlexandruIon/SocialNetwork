package ro.dezertatie.common.dao;


import ro.dezertatie.common.domain.BaseEntity;

import java.io.Serializable;
import java.util.Collection;

/**
 * Interface supporting CRUD operations.
 *
 * @param <T> entity type; must have id of type I
 * @param <I> entity I type
 */
public interface CrudDao<T extends BaseEntity<I>, I extends Serializable> {

    /**
     * Saves a given entity.
     *
     * @param entity entity to be saved
     * @return saved entity to be used for further operations
     * @throws IllegalArgumentException in case of null entity
     */
    <S extends T> S save(S entity);

    /**
     * Saves all the given entities.
     *
     * @param entities
     * @return instances of saved entities to be used for further operations
     * @throws IllegalArgumentException in case of null entities
     */
    <S extends T> Collection<S> save(Iterable<S> entities);

    /**
     * Removes an entity by id
     *
     * @param id id of the entity to be removed; must not be null
     * @throws IllegalArgumentException if id is null
     */
    void delete(I id);

    /**
     * Removes an entity
     *
     * @param entity entity to be removed; must not be null
     * @throws IllegalArgumentException in case entity is null
     */
    void delete(T entity);

    /**
     * Removes all the given entities
     *
     * @param entities
     * @throws IllegalArgumentException in case entities parameter is null
     */
    void delete(Iterable<? extends T> entities);

    /**
     * Retrieves an entity by id.
     *
     * @param id must not be null
     * @return the corresponding entity or null if the given id is not present
     * @throws IllegalArgumentException if id is null
     */
    T findOne(I id);

    /**
     * Retrieves all the entities
     *
     * @return found entities or empty collection
     */
    Collection<T> findAll();

    /**
     * Retrieves all the entities with the given ids, if available.
     *
     * @param ids must not be null
     * @return found entities or empty structure
     * @throws IllegalArgumentException if ids is null
     */
    Collection<T> findAll(Iterable<I> ids);

    /**
     * @return the number of all available entities
     */
    long count();
}
