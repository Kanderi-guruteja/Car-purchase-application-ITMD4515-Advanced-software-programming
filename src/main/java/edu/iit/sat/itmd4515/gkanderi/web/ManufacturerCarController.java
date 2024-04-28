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
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author 18722
 */
@Named
@RequestScoped
public class ManufacturerCarController {

    private static final Logger LOG = Logger.getLogger(ManufacturerCarController.class.getName());
    
    @EJB CarService CarService;
    @EJB ManufacturerService ManufacturerService;
    @Inject ManufacturerWelcomeController mwc;
    
    private Car car;

    public ManufacturerCarController() {
    }

    @PostConstruct
    private void postConstruct() {
        car = new Car();
        LOG.info("CarController.postConstruct");
    }
    public CarType[] getAllCarTypesForForm(){
        return CarType.values();
    }
    
    // action methods
    /**
     * MVC style JSF navigation method for viewing a pet in read-only mode
     *
     * Step 1 - Accept the "click" and set the model with the associated
     * parameter, typically coming from a JSF data table.
     *
     * Step 2 - Navigating the user to the intended or appropriate JSF view to
     * complete their operation.
     *
     * Step 3 - If applicable, is invoking the action or application (in JSF
     * lifecycle terminology), and then likely returning the user to some other
     * view as a final result.  This would effectively mean, handling the click 
     * from the JSF view in step 2, in order to perform the operation the user
     * is trying to accomplish.
     *
     * @param p
     * @return
     */
    
    
   public String displayViewCarPage(Car c) {
        // Step 1 - accept the click and set the model
        this.car = c;
        LOG.info("Inside displayViewPetPage with model " + c.toString());

        // Step 2 - navigate the user to the intended or appropriate JSF view
        return "/manufacturer/viewCar.xhtml";
    }

    public String displayEditCarPage(Car c) {
        // Step 1 - accept the click and set the model
        this.car = c;
        LOG.info("Inside displayEditPetPage with model " + c.toString());

        // Step 2 - navigate the user to the intended or appropriate JSF view
        return "/manufacturer/editCar.xhtml";
    }
   
   
       public String displayDeleteCarPage(Car c) {
        // Step 1 - accept the click and set the model
        this.car = c;
        LOG.info("Inside displayDeleteCarPage with model " + c.toString());

        // Step 2 - navigate the user to the intended or appropriate JSF view
        return "/manufacturer/deleteCar.xhtml";
    }
   
   

    public String saveCar() {
        LOG.info("saveCar has been invoked with model: " + this.car.toString());

        ManufacturerService.createCarForManufacturer(mwc.getManufacturer(), car);

        LOG.info("saveCar after calling service layer: " + this.car.toString());
        
        mwc.refreshManufacturerModel();
        
        return "welcome.xhtml";
    }
    
 public String editCar() {
    LOG.info("editCar has been invoked with model: " + this.car.toString());
    
    // Check if the car has a valid id before editing
    if (this.car.getId() != null) {
        LOG.info("Car ID: " + this.car.getId()); // Add this line for debugging
        CarService.editCarForExistingManufacturer(car);
        mwc.refreshManufacturerModel();
    } else {
        LOG.warning("Cannot edit car. Car ID is null.");
        // Handle the error appropriately, e.g., display a message to the user
    }

    return "/manufacturer/welcome.xhtml";
}



public String deleteCar() {
    LOG.info("deleteCar has been invoked with model: " + this.car.toString());
    return "/manufacturer/welcome.xhtml";
}
    
    
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
