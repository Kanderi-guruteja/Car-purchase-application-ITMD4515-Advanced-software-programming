/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Leasingoffice;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author 18722
 */
@Stateless
public class LeasingofficeService {
    @PersistenceContext(unitName = "itmd4515PU")
    private EntityManager em;

    public void create(Leasingoffice l) {
        em.persist(l);
    }

    public Leasingoffice read(Long id) {
        return em.find(Leasingoffice.class, id);
    }

   public void update(Leasingoffice l) {
    try {
        em.merge(l);
    } catch (OptimisticLockException e) {
        try {
            Leasingoffice managedLeasingoffice = em.getReference(Leasingoffice.class, l.getId());
         
            em.refresh(managedLeasingoffice);
            em.merge(l);
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
    public void delete(Leasingoffice l) {
        em.remove(em.merge(l));
    }
    public Leasingoffice refresh(Leasingoffice l) {
        em.refresh(l);
        return l;
    }
    public List<Leasingoffice> findAll() {
        return em.createNamedQuery("Leasingoffice.findAll", Leasingoffice.class).getResultList();
    }
}