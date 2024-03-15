/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.Salesstaff;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author 18722
 */
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
    
}
