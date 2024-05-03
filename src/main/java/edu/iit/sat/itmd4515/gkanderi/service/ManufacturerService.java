/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.Manufacturer;
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

    public ManufacturerService() {
        super(Manufacturer.class);
    }
    
   public Manufacturer findByUsername(String username) {
    List<Manufacturer> results = em.createNamedQuery("Manufacturer.findByUsername", Manufacturer.class)
                                   .setParameter("uname", username)
                                   .getResultList();

    if (!results.isEmpty()) {
        return results.get(0);
    } else {
        return null;    }
}



    public List<Manufacturer> findAll() {
        return super.findAll("Manufacturer.findAll");
    }
    
    public void createCarForManufacturer(Manufacturer manufacturer, Car car) {
        
        em.persist(car);

        Manufacturer manufacturerRef = em.getReference(Manufacturer.class, manufacturer.getId());
        manufacturerRef.addCar(car);
        em.merge(manufacturerRef);
    }
    
  
    
    
}


