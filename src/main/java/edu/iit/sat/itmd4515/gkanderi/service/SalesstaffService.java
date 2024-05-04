package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Salesstaff;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 * A service class for managing sales staff.
 * Provides methods for creating, reading, updating, and deleting sales staff entities.
 * Includes methods to find sales staff by ID, username, and retrieve all sales staff entities.
 * @author 18722
 */
@Named
@Stateless
public class SalesstaffService {

    @PersistenceContext(unitName = "itmd4515PU")
    private EntityManager em;

    /**
     * Creates a new sales staff entity in the database.
     * @param s The sales staff entity to create.
     */
    public void create(Salesstaff s) {
        em.persist(s);
    }

    /**
     * Retrieves a sales staff entity by its ID.
     * @param id The ID of the sales staff entity to retrieve.
     * @return The sales staff entity with the specified ID, or null if not found.
     */
    public Salesstaff read(Long id) {
        return em.find(Salesstaff.class, id);
    }

    /**
     * Updates an existing sales staff entity in the database.
     * @param s The sales staff entity to update.
     */
    public void update(Salesstaff s) {
        em.merge(s);
    }

    /**
     * Deletes a sales staff entity from the database by its ID.
     * @param id The ID of the sales staff entity to delete.
     */
    public void delete(Long id) {
        Salesstaff s = em.find(Salesstaff.class, id);
        if (s != null) {
            em.remove(s);
        }
    }

    /**
     * Retrieves all sales staff entities from the database.
     * @return A list of all sales staff entities.
     */
    public List<Salesstaff> findAll() {
        return em.createQuery("SELECT s FROM Salesstaff s", Salesstaff.class).getResultList();
    }

    /**
     * Retrieves a sales staff entity by its username.
     * @param username The username of the sales staff entity to retrieve.
     * @return The sales staff entity with the specified username, or null if not found.
     */
    public Salesstaff findByUsername(String username) {
        return em.createNamedQuery("Salesstaff.findByUsername", Salesstaff.class).setParameter("uname", username).getSingleResult();
    }
}
