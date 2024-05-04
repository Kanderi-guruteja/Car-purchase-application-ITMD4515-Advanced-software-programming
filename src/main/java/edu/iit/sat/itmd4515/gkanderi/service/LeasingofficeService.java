package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Leasingoffice;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 * A service class for managing leasing offices.
 * Provides methods for creating, reading, updating, and deleting leasing offices.
 * Also includes a method for refreshing a leasing office entity.
 * @author 18722
 */
@Stateless
public class LeasingofficeService {
    @PersistenceContext(unitName = "itmd4515PU")
    private EntityManager em;

    /**
     * Creates a new leasing office in the database.
     * @param leasingoffice The leasing office to be created.
     */
    public void create(Leasingoffice leasingoffice) {
        em.persist(leasingoffice);
    }

    /**
     * Retrieves a leasing office from the database by its ID.
     * @param id The ID of the leasing office to retrieve.
     * @return The leasing office entity with the specified ID.
     */
    public Leasingoffice read(Long id) {
        return em.find(Leasingoffice.class, id);
    }

    /**
     * Updates an existing leasing office in the database.
     * @param leasingoffice The leasing office with updated information.
     */
    public void update(Leasingoffice leasingoffice) {
        try {
            em.merge(leasingoffice);
        } catch (OptimisticLockException e) {
            try {
                Leasingoffice managedLeasingoffice = em.getReference(Leasingoffice.class, leasingoffice.getId());
                em.refresh(managedLeasingoffice);
                em.merge(leasingoffice);
            } catch (EntityNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Deletes a leasing office from the database.
     * @param leasingoffice The leasing office to be deleted.
     */
    public void delete(Leasingoffice leasingoffice) {
        em.remove(em.merge(leasingoffice));
    }

    /**
     * Refreshes a leasing office entity with the latest state from the database.
     * @param leasingoffice The leasing office entity to be refreshed.
     * @return The refreshed leasing office entity.
     */
    public Leasingoffice refresh(Leasingoffice leasingoffice) {
        em.refresh(leasingoffice);
        return leasingoffice;
    }

    /**
     * Retrieves all leasing offices from the database.
     * @return A list of all leasing offices.
     */
    public List<Leasingoffice> findAll() {
        return em.createNamedQuery("Leasingoffice.findAll", Leasingoffice.class).getResultList();
    }
}
