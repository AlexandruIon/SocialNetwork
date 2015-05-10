package ro.dezertatie.common.dao;


import ro.dezertatie.common.domain.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Collection;

public class JpaCrudDao<T extends BaseEntity<I>, I extends Serializable> implements CrudDao<T, I> {

    @PersistenceContext
    private EntityManager em;

    public T create(T entity) {
        return null;
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
