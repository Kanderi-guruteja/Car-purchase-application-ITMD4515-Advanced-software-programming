package edu.iit.sat.itmd4515.gkanderi.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 18722
 */

/**
 * An abstract service class providing basic CRUD operations for entities.
 * @param <T> The type of entity managed by this service.
 */
public abstract class AbstractService<T> {

    /**
     *
     */
    @PersistenceContext(name = "itmd4515PU")
    protected EntityManager em;
    
    /**
     *
     */
    protected Class<T> entityClass;

    /**
     * Constructs a new AbstractService with the given entity class.
     * @param entityClass The class of the entity managed by this service.
     */
    protected AbstractService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Persists the given entity in the database.
     * @param entity The entity to be persisted.
     */
    public void create(T entity) {
        em.persist(entity);
    }

    /**
     * Retrieves an entity from the database with the given ID.
     * @param id The ID of the entity to retrieve.
     * @return The entity with the given ID, or null if not found.
     */
    public T read(Long id) {
        return em.find(entityClass, id);
    }

    /**
     * Updates the given entity in the database.
     * @param entity The entity to be updated.
     */
    public void update(T entity) {
        em.merge(entity);
    }

    /**
     * Deletes the given entity from the database.
     * @param entity The entity to be deleted.
     */
    public void delete(T entity) {
        em.remove(em.merge(entity));
    }

    /**
     * Retrieves all entities of type T from the database using a named query.
     * @param namedQueryName The name of the named query to execute.
     * @return A list of all entities retrieved.
     */
    protected List<T> findAll(String namedQueryName) {
        return em.createNamedQuery(namedQueryName, entityClass).getResultList();
    }
    
    /**
     * Retrieves a single result from a JPQL query with the given parameters.
     * @param jpql The JPQL query string.
     * @param parameters A map of query parameters and their values.
     * @return The single result entity, or null if no result found.
     */
    protected T findOneResult(String jpql, Map<String, Object> parameters) {
        TypedQuery<T> query = em.createQuery(jpql, entityClass);
        parameters.forEach(query::setParameter);
        List<T> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }
}
