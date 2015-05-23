package ro.dezertatie.common.dao;


import ro.dezertatie.common.DataRepository;
import ro.dezertatie.common.PersistenceUnitType;
import ro.dezertatie.common.domain.BaseEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

public class JpaCrudDao<T extends BaseEntity<I>, I extends Serializable> implements CrudDao<T, I> {

    public static final String FIND_ALL = "FIND_ALL";

    protected static final IllegalArgumentException NULL_ARGUMENT_EXCEPTION =
            new IllegalArgumentException("Null argument is not allowed.");
    private static final String PROXY_NAME = "proxy";
    protected final transient Class<T> entityClass;
    private transient SingularAttribute<T, I> idAttribute;

    @Inject
    @DataRepository(PersistenceUnitType.MONGO)
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public JpaCrudDao() {

        Class<?> classObj = getClass();
        // if the object is a proxy get the real object Dao s annotated with an interceptor creates a proxy object.
        if (isProxy(classObj)) {
            classObj = classObj.getSuperclass();
        }

        Type[] genericArguments = ((ParameterizedType) classObj.getGenericSuperclass()).getActualTypeArguments();

        Type entityType = genericArguments[0];
        if (Class.class.isAssignableFrom(entityType.getClass())) {
            // T is a subclass of BaseEntity
            entityClass = (Class<T>) entityType;
        } else {
            // T is BaseEntity itself
            entityClass = (Class<T>) ((ParameterizedType) entityType).getRawType();
        }
    }

    /**
     * Whether the given class is a proxy created by CDI implementation or not.
     *
     * @param clazz the class of interest
     * @return {@code true} if the given class is a proxy,
     * {@code false} otherwise
     */
    private boolean isProxy(Class<?> clazz) {
        //maybe there is a better way than this; Proxy.isProxyClass(clazz) is not working
        return clazz.getSimpleName().toLowerCase().contains(PROXY_NAME);
    }

    @Override
    public <S extends T> S save(S entity) {
        if (entity == null) {
            throw NULL_ARGUMENT_EXCEPTION;
        }
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entity);
        return entity;
    }

    @Override
    public <S extends T> Collection<S> save(Iterable<S> entities) {
        throw new UnsupportedOperationException("unimplemented");
    }

    @Override
    public void delete(I id) {
        delete(findOne(id));
    }

    @Override
    public void delete(T entity) {
        if (entity == null) {
            throw NULL_ARGUMENT_EXCEPTION;
        }
        // no need to delete the entity if it was never saved
        if (entity.getId() != null) {
            // before removing, check if entity has been detached and merge it
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
            // flush is needed when we have constraints on entities, otherwise adding a new entity
            // after removing another might cause constraint violation - EclipseLink bug ??
            entityManager.flush();
        }
    }

    @Override
    public void delete(Iterable<? extends T> entities) {
        throw new UnsupportedOperationException("unimplemented");
    }

    @Override
    public T findOne(I id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public Collection<T> findAll() {
        TypedQuery<T> query = entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass);
        return query.getResultList();
    }

    @Override
    public Collection<T> findAll(Iterable<I> ids) {
        throw new UnsupportedOperationException("unimplemented");
    }

    @Override
    public long count() {
        return 0;
    }
}
