package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Reservation;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ReservationService {
    
    @PersistenceContext(unitName = "itmd4515PU")
    private EntityManager entityManager;

    public void create(Reservation reservation) {
        entityManager.persist(reservation);
    }

    public void update(Reservation reservation) {
        entityManager.merge(reservation);
    }

    public void delete(Reservation reservation) {
        entityManager.remove(entityManager.contains(reservation) ? reservation : entityManager.merge(reservation));
    }

    public Reservation findById(Long id) {
        return entityManager.find(Reservation.class, id);
    }

    public List<Reservation> findAll() {
        return entityManager.createQuery("SELECT r FROM Reservation r", Reservation.class).getResultList();
    }

    // Add more methods as needed
}
