/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.CarType;
import edu.iit.sat.itmd4515.gkanderi.service.CarService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

/**
 *
 * @author 18722
 */
@Named
@RequestScoped
public class CarController {
    @EJB  CarService carsvc;
    
    public CarType getCarType(String value) {
        return CarType.valueOf(value.toUpperCase());
    }
    private Car car;

    /**
     * Get the value of car
     *
     * @return the value of car
     */
    public Car getCar() {
        return car;
    }

    /**
     * Set the value of car
     *
     * @param car new value of car
     */
    public void setCar(Car car) {
        this.car = car;
    }

    
    private static final Logger LOG = Logger.getLogger(CarController.class.getName());
    
    public CarController() {
        
    }
    @PostConstruct
    private void PostConstruct(){
        car = new Car();
        car.setType(CarType.PETROL);
        LOG.info("carController.postconstruct");
                
    }
    
    public CarType[] getAllCarTypesForForm() {
    return CarType.values();
}

    
   public String demoAction() {
     LOG.info("demoAction has been invoked with model: " + car);
    return "confirmation.xhtml";
}
   public String saveCar() {
     LOG.info("saveCar has been invoked with model: " + car);
     carsvc.create(car);
     LOG.info("saveCar hafter calling serive layer: " + car);
    return "confirmation.xhtml";
}
}
