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

	public <S extends T> S save(S entity) {
		if (entity == null) {
			throw NULL_ARGUMENT_EXCEPTION;
		}
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		return entity;
	}

	public <S extends T> Collection<S> save(Iterable<S> entities) {
		return null;
	}

	public void delete(I id) {

	}

	public void delete(T entity) {

	}

	public void delete(Iterable<? extends T> entities) {

	}

	public T findOne(I id) {
		return null;
	}

	public T findOneDetached(I id) {
		return null;
	}

	public Collection<T> findAll() {
		return null;
	}

	public Collection<T> findAll(Iterable<I> ids) {
		return null;
	}

	public long count() {
		return 0;
	}
}
