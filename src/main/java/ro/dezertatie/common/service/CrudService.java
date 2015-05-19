package ro.dezertatie.common.service;

import ro.dezertatie.common.domain.BaseEntity;
import ro.dezertatie.common.domain.BusinessException;

import java.io.Serializable;
import java.util.Collection;

public interface CrudService<T extends BaseEntity<I>, I extends Serializable, E extends BusinessException> {

	/**
	 * Creates a new <T> entity
	 *
	 * @param entity to be added
	 * @return the added entity including an ID
	 * @throws &lt;E&gt; if the argument is null or any error occurs while saving the entity
	 */
	T create(T entity);


	/**
	 * Updates <T> entity, the given entity has already been created.
	 *
	 * @param entity to be updated
	 * @return the updated entity including an ID
	 * @throws &lt;E&gt; if the argument is null or any error occurs while saving the entity
	 */
	T update(T entity);


	/**
	 * Deletes an existing entity from the persistence layer.
	 * It does nothing if the entity has not been saved before.
	 *
	 * @param entity entity instance to be deleted
	 * @throws &lt;E&gt; if the argument is null or any error occurs during removal
	 */
	void delete(T entity);

	/**
	 * Deletes an existing entity from the persistence layer.
	 * It does nothing if the entity has not been saved before.
	 *
	 * @param id id of the entity instance to be deleted
	 * @throws &lt;E&gt; if the argument is null, if no entity found for that ID or any error occurs during removal
	 */
	void deleteById(I id);

	/**
	 * Retrieves an entity by ID
	 *
	 * @param id to search for
	 * @return entity with the given ID or null if not found
	 * @throws &lt;E&gt; if the argument is null or any error occurs during retrieval
	 */
	T get(I id);

	/**
	 * Retrieves all the entities available.
	 *
	 * @return all the available entities.
	 * @throws &lt;E&gt; if any error occurs during retrieval
	 */
	Collection<T> getAll();

	/**
	 * Retrieves entities between the given bounds.
	 * Please note that there might be less than "limit" entities available from the given offset,
	 * so you must check the result size to obtain the real number of entities retrieved.
	 *
	 * @param offset starting index should be >= 0 and less than the total number of entities available
	 * @param limit  the number of elements to be retrieved from the given offset. Should be greater than 0.
	 * @return a subset of entities between the given bounds
	 * @throws &lt;E&gt; if invalid values are passed or any error occurs during retrieval
	 */
	Collection<T> getAll(long offset, long limit);

}
