/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.Manufacturer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author 18722
 */
@Stateless
public class ManufacturerService {
    @PersistenceContext(unitName = "itmd4515PU")
    private EntityManager em;

    public void create(Manufacturer m) {
        em.persist(m);
    }

    public Manufacturer read(Long id) {
        return em.find(Manufacturer.class, id);
    }

    public void update(Manufacturer m) {
        em.merge(m);
    }

    public void delete(Long id) {
        Manufacturer m = em.find(Manufacturer.class, id);
        if (m != null) {
            em.remove(m);
        }
    }

    public List<Manufacturer> findAll() {
        return em.createNamedQuery("Manufacturer.findAll", Manufacturer.class).getResultList();
    }
}
