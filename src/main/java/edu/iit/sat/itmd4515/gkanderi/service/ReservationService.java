package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Reservation;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

/**
 * A service class for managing reservations.
 * Provides methods for creating, updating, deleting, and retrieving reservations.
 * Includes methods to retrieve all reservations, find a reservation by ID,
 * retrieve upcoming reservations, and more as needed.
 * @author 18722
 */
@Stateless
public class ReservationService {
    
    @PersistenceContext(unitName = "itmd4515PU")
    private EntityManager entityManager;
    
    /**
     * Retrieves all reservations from the database.
     * @return A list of all reservations.
     */
    public List<Reservation> getAllReservations() {
        return entityManager.createQuery("SELECT r FROM Reservation r", Reservation.class)
                             .getResultList();
    }

    /**
     * Creates a new reservation in the database.
     * @param reservation The reservation to create.
     */
    public void create(Reservation reservation) {
        entityManager.persist(reservation);
    }

    /**
     * Updates an existing reservation in the database.
     * @param reservation The reservation to update.
     */
    public void update(Reservation reservation) {
        entityManager.merge(reservation);
    }

    /**
     * Deletes a reservation from the database.
     * @param reservation The reservation to delete.
     */
    public void delete(Reservation reservation) {
        entityManager.remove(entityManager.contains(reservation) ? reservation : entityManager.merge(reservation));
    }

    /**
     * Finds a reservation by its ID.
     * @param id The ID of the reservation to find.
     * @return The reservation with the specified ID, or null if not found.
     */
    public Reservation findById(Long id) {
        return entityManager.find(Reservation.class, id);
    }

    /**
     * Retrieves all reservations from the database.
     * @return A list of all reservations.
     */
    public List<Reservation> findAll() {
        return entityManager.createQuery("SELECT r FROM Reservation r", Reservation.class).getResultList();
    }
    
    /**
     * Retrieves upcoming reservations from the database.
     * @return A list of upcoming reservations.
     */
    public List<Reservation> getUpcomingReservations() {
        LocalDate currentDate = LocalDate.now();
        return entityManager.createQuery(
                "SELECT r FROM Reservation r WHERE r.reservationDate > :currentDate", Reservation.class)
                .setParameter("currentDate", currentDate)
                .getResultList();
    }

    
}
