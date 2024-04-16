/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.CarType;
import edu.iit.sat.itmd4515.gkanderi.service.CarService;
import edu.iit.sat.itmd4515.gkanderi.service.ManufacturerService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.logging.Logger;

/**
 *
 * @author 18722
 */
@Named
@RequestScoped
public class ManufacturerCreateCarController {

    private static final Logger LOG = Logger.getLogger(ManufacturerCreateCarController.class.getName());
    
    @EJB CarService CarService;
    @EJB ManufacturerService ManufacturerService;
    @Inject ManufacturerWelcomeController mwc;
    
    private Car car;

    public ManufacturerCreateCarController() {
    }

    @PostConstruct
    private void postConstruct() {
        car = new Car();
        LOG.info("CarController.postConstruct");
    }
    public CarType[] getAllCarTypesForForm(){
        return CarType.values();
    }
    public String demoAction() {
        LOG.info("demoAction has been invoked with model: " + this.car.toString());

        return "confirmation.xhtml";
    }

    public String saveCar() {
        LOG.info("saveCar has been invoked with model: " + this.car.toString());

        ManufacturerService.createCarForManufacturer(mwc.getManufacturer(), car);

        LOG.info("saveCar after calling service layer: " + this.car.toString());
        
        return "confirmation.xhtml";
    }
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
