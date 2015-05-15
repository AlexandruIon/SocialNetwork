package ro.dezertatie.common.dao;


import ro.dezertatie.common.domain.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Collection;

public class JpaCrudDao<T extends BaseEntity<I>, I extends Serializable> implements CrudDao<T, I> {

	protected static final IllegalArgumentException NULL_ARGUMENT_EXCEPTION =
			new IllegalArgumentException("Null argument is not allowed.");

	@PersistenceContext
	protected EntityManager entityManager;

	public T create(T entity) {
		if (entity == null) {
			throw NULL_ARGUMENT_EXCEPTION;
		}
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		return entity;
	}

	public T update(T entity) {
		return null;
	}

	public void delete(T entity) {

	}

	public T findOne(I id) {
		return null;
	}

	public Collection<T> findAll() {
		return null;
	}
}
