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
 * The ManufacturerCarController class manages cars for manufacturers in the web application.
 * It provides methods for displaying, editing, deleting, and saving cars.
 * 
 * @author 18722
 */
@Named
@RequestScoped
public class ManufacturerCarController {

    private static final Logger LOG = Logger.getLogger(ManufacturerCarController.class.getName());

    @EJB
    CarService CarService;

    @EJB
    ManufacturerService ManufacturerService;

    @Inject
    ManufacturerWelcomeController mwc;

    private Car car;

    /**
     * Initializes the ManufacturerCarController after construction.
     */
    @PostConstruct
    private void postConstruct() {
        car = new Car();
        LOG.info("CarController.postConstruct");
    }

    /**
     * Retrieves all car types for a form.
     * 
     * @return An array of car types.
     */
    public CarType[] getAllCarTypesForForm() {
        return CarType.values();
    }

    /**
     * Displays the view car page for a given car.
     * 
     * @param c The car to view.
     * @return The outcome page.
     */
    public String displayViewCarPage(Car c) {
        this.car = c;
        LOG.info("Inside displayViewCarPage with model " + c.toString());
        return "/manufacturer/viewCar.xhtml";
    }

    /**
     * Displays the edit car page for a given car.
     * 
     * @param c The car to edit.
     * @return The outcome page.
     */
    public String displayEditCarPage(Car c) {
        this.car = c;
        LOG.info("Inside displayEditCarPage with model " + c.toString());
        return "/manufacturer/editCar.xhtml";
    }

    /**
     * Displays the delete car page for a given car.
     * 
     * @param c The car to delete.
     * @return The outcome page.
     */
    public String displayDeleteCarPage(Car c) {
        this.car = c;
        LOG.info("Inside displayDeleteCarPage with model " + c.toString());
        return "/manufacturer/deleteCar.xhtml";
    }

    /**
     * Saves the car.
     * 
     * @return The outcome page after saving the car.
     */
   public String saveCar() {
        LOG.info("saveCar has been invoked with model: " + this.car.toString());

        
        ManufacturerService.createCarForManufacturer(mwc.getManufacturer(), car);

        LOG.info("saveCar after calling service layer: " + this.car.toString());

        mwc.refreshManufacturerModel();
        
        return "/manufacturer/welcome.xhtml";
    }

    /**
     * Edits the car.
     * 
     * @return The outcome page after editing the car.
     */
    public String editCar(){
        LOG.info("editCar has been invoked with model: " + this.car.toString());
        
        CarService.editCarForExistingManufacturer(car);

        mwc.refreshManufacturerModel();
        
        return "/manufacturer/welcome.xhtml";
    }

    /**
     * Deletes the car.
     * 
     * @return The outcome page after deleting the car.
     */
     /**
 * Deletes the car.
 * 
 * @return The outcome page after deleting the car.
 */
public String deleteCar(){
        LOG.info("deleteCar has been invoked with model: " + this.car.toString());
        
        return "/manufacturer/welcome.xhtml";
    }
    /**
     * Retrieves the car.
     * 
     * @return The car.
     */
    public Car getCar() {
        return car;
    }

    /**
     * Sets the car.
     * 
     * @param car The car to set.
     */
    public void setCar(Car car) {
        this.car = car;
    }
}
