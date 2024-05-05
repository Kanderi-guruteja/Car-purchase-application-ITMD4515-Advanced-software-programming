/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Manufacturer;
import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author 18722
 */
@Named
@Stateless
public class ManufacturerService extends AbstractService<Manufacturer> {

    /**
     *
     */
    public ManufacturerService() {
        super(Manufacturer.class);
    }

    /**
     *
     * @return
     */
    public List<Manufacturer> findAll() {
        return super.findAll("Manufacturer.findAll");
    }

    /**
     *
     * @param username
     * @return
     */
    public Manufacturer findByUsername(String username) {
        return em.createNamedQuery("Manufacturer.findByUsername", Manufacturer.class).setParameter("uname", username).getSingleResult();
    }

     public void createCarForManufacturer(Manufacturer manufacturer, Car car) {
        em.persist(car);
        Manufacturer manufacturerRef = em.getReference(Manufacturer.class, manufacturer.getId());
        manufacturerRef.addCar(car);
        em.merge(manufacturerRef);
    }

    
}
