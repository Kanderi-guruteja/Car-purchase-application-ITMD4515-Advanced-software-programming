package edu.iit.sat.itmd4515.gkanderi.web;

import java.util.List;
import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.service.CarService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class DefaultWelcomeController {

    @Inject
    private CarService carService;

    private List<Car> availableCars;

    public DefaultWelcomeController() {
    }

    @PostConstruct
    private void postConstruct() {
        availableCars = carService.findAll();
    }

    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public void reserveCar(Car c) {
        // Create a reservation for the selected car
        // This logic has been moved to the ReservationBean class
    }
}
