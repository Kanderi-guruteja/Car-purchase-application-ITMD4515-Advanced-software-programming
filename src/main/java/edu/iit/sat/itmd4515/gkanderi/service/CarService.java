package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.Salesstaff;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.util.List;

/**
 * A service class for managing cars.
 * Extends the AbstractService class providing basic CRUD operations for Car entities.
 * Also provides additional methods for creating cars and handling car edits.
 * @author 18722
 */
@Named
@Stateless
public class CarService extends AbstractService<Car> {

    /**
     * Constructs a new CarService.
     * Initializes the service with the Car entity class.
     */
    public CarService() {
        super(Car.class);
    }

    /**
     * Retrieves all cars from the database.
     * @return A list of all cars.
     */
    public List<Car> findAll() {
        return super.findAll("Car.findAll");
    }

    /**
     * Creates a new car in the database.
     * @param car The car to be created.
     */
    public void createCar(Car car) {
        super.create(car);
    }

    /**
     * Creates a new sales staff member in the database.
     * @param salesStaff The sales staff member to be created.
     */
    public void createSalesstaff(Salesstaff salesStaff) {
        // Implementation for creating a sales staff member
    }
    
    /**
     * Edits an existing car for an existing manufacturer.
     * @param car The car with updated information.
     */
    public void editCarForExistingManufacturer(Car car){
        Car managedRef = em.getReference(Car.class, car.getId());
        
        managedRef.setName(car.getName());
        managedRef.setBuyDate(car.getBuyDate());
        managedRef.setType(car.getType());
        
        em.merge(managedRef);
    }
}
