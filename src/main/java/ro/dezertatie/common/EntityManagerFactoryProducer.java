package ro.dezertatie.common;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;

@ApplicationScoped
public class EntityManagerFactoryProducer implements Serializable {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager em;


    @Produces
    public EntityManagerFactory createEntityManagerFactoryMongo() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("mongo-pu");
        }
        return entityManagerFactory;
    }

    @Produces
    public EntityManagerFactory createEntityManagerFactoryCassandra() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("mongo-pu");
        }
        return entityManagerFactory;
    }

    @Produces
    @ApplicationScoped
    @DataRepository(PersistenceUnitType.MONGO)
    public EntityManager createEntityManagerMongo() {
        em = createEntityManagerFactoryMongo().createEntityManager();
        return em;
    }

    @Produces
    @RequestScoped
    @DataRepository(PersistenceUnitType.CASSANDRA)
    public EntityManager createEntityManagerCassandra() {
        em = createEntityManagerFactoryCassandra().createEntityManager();
        return em;
    }

    public void closeMongo(@Disposes @DataRepository(PersistenceUnitType.MONGO) EntityManager entityManager) {
        em.close();
    }

    public void closeCassandra(@Disposes @DataRepository(PersistenceUnitType.CASSANDRA) EntityManager entityManager) {
        em.close();
    }
}


