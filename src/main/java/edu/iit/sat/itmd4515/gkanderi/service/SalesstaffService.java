/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Salesstaff;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class SalesstaffService {
    @PersistenceContext(unitName = "itmd4515PU")
    private EntityManager em;

    public void create(Salesstaff s) {
        em.persist(s);
    }

    public Salesstaff read(Long id) {
        return em.find(Salesstaff.class, id);
    }

    public void update(Salesstaff s) {
        em.merge(s);
    }

    public void delete(Long id) {
        Salesstaff s = em.find(Salesstaff.class, id);
        if (s != null) {
            em.remove(s);
        }
    }

    public List<Salesstaff> findAll() {
        return em.createQuery("SELECT s FROM Salesstaff s", Salesstaff.class).getResultList();
    }
}



