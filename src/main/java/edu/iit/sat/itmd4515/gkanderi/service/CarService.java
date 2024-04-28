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

    /**
     *
     */
    public CarService() {
        super(Car.class);
    }

    /**
     *
     * @return
     */
    public List<Car> findAll() {
        return super.findAll("Car.findAll");
    }

    /**
     *
     * @param car
     */
    public void createCar(Car car) {
        super.create(car);
    }

    /**
     *
     * @param Salesstaff
     */
    public void createSalesstaff(Salesstaff Salesstaff) {
        
    }
    
    /**
     *
     * @param c
     */
    public void editCarForExistingManufacturer(Car c){
        Car managedRef=em.getReference(Car.class, c.getId());
        
        managedRef.setName(c.getName());
        managedRef.setBuyDate(c.getBuyDate());
        managedRef.setType(c.getType());
        
        em.merge(managedRef);
    }
    
}
