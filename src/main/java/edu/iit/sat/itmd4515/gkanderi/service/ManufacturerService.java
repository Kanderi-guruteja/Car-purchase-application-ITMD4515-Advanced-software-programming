package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.Manufacturer;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.util.List;

/**
 * A service class for managing manufacturers.
 * Provides methods for creating, reading, and finding manufacturers.
 * Also includes a method for creating a car associated with a manufacturer.
 * @author 18722
 */
@Named
@Stateless
public class ManufacturerService extends AbstractService<Manufacturer> {

    /**
     * Constructs a ManufacturerService instance.
     * Initializes the service with the Manufacturer entity class.
     */
    public ManufacturerService() {
        super(Manufacturer.class);
    }
    
    /**
     * Finds a manufacturer by username.
     * @param username The username of the manufacturer to find.
     * @return The manufacturer with the specified username, or null if not found.
     */
    public Manufacturer findByUsername(String username) {
        List<Manufacturer> results = em.createNamedQuery("Manufacturer.findByUsername", Manufacturer.class)
                                       .setParameter("uname", username)
                                       .getResultList();

        if (!results.isEmpty()) {
            return results.get(0);
        } else {
            return null;
        }
    }

    /**
     * Retrieves all manufacturers from the database.
     * @return A list of all manufacturers.
     */
    public List<Manufacturer> findAll() {
        return super.findAll("Manufacturer.findAll");
    }
    
    /**
     * Creates a car associated with a manufacturer.
     * @param manufacturer The manufacturer to associate the car with.
     * @param car The car to be created and associated with the manufacturer.
     */
    public void createCarForManufacturer(Manufacturer manufacturer, Car car) {
        em.persist(car);

        Manufacturer manufacturerRef = em.getReference(Manufacturer.class, manufacturer.getId());
        manufacturerRef.addCar(car);
        em.merge(manufacturerRef);
    } 
}
