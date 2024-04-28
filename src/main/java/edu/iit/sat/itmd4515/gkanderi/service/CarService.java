/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.Salesstaff;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author 18722
 */
@Named
@Stateless
public class CarService extends AbstractService<Car> {

     public CarService() {
        super(Car.class);
    }

    public List<Car> findAll() {
        return super.findAll("Car.findAll");
    }

    public void createCar(Car car) {
        super.create(car);
    }

   
    public void createSalesstaff(Salesstaff Salesstaff) {
        
    }
    
      public void editCarForExistingManufacturer(Car c){
        Car managedRef=em.getReference(Car.class, c.getId());
        
        managedRef.setName(c.getName());
        managedRef.setBuyDate(c.getBuyDate());
        managedRef.setType(c.getType());
        
        em.merge(managedRef);
    }
    
}
