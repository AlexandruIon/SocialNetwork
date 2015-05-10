package ro.dezertatie.common.service;

import ro.dezertatie.common.domain.BaseEntity;

import java.io.Serializable;
import java.util.Collection;

public interface CrudService<T extends BaseEntity<I>, I extends Serializable> {

    T create(T entity);

    T update(T entity);

    void delete(T entity);

    T findOne(I id);

    Collection<T> findAll();

}
