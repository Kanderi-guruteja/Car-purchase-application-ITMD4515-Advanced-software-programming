package edu.iit.sat.itmd4515.gkanderi.web;

import java.util.List;
import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.service.CarService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * The DefaultWelcomeController class is responsible for managing the default welcome page.
 * It retrieves a list of available cars from the CarService and provides a method to reserve a car.
 * This class is annotated as @Named to be managed by CDI and @RequestScoped to have request scope.
 * 
 * @author 18722
 */
@Named
@RequestScoped
public class DefaultWelcomeController {

    @Inject
    private CarService carService;

    private List<Car> availableCars;

    /**
     * DefaultWelcomeController constructor.
     */
    public DefaultWelcomeController() {
    }

    /**
     * Initializes the DefaultWelcomeController after injection.
     * Retrieves the list of available cars from the CarService.
     */
    @PostConstruct
    private void postConstruct() {
        availableCars = carService.findAll();
    }

    /**
     * Gets the list of available cars.
     *
     * @return The list of available cars.
     */
    public List<Car> getAvailableCars() {
        return availableCars;
    }

    /**
     * Reserves a car.
     *
     * @param c The car to be reserved.
     */
    public void reserveCar(Car c) {
        // Create a reservation for the selected car
        // This logic has been moved to the ReservationBean class
    }
}
