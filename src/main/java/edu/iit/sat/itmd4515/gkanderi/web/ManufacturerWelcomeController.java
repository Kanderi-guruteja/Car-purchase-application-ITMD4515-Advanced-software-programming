package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Manufacturer;
import edu.iit.sat.itmd4515.gkanderi.service.CarService;
import edu.iit.sat.itmd4515.gkanderi.service.ManufacturerService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.logging.Logger;

/**
 * The ManufacturerWelcomeController class manages the welcome page for manufacturers after login.
 * It retrieves the authenticated manufacturer's details and provides methods to refresh the manufacturer model.
 * 
 * @author 18722
 */
@Named
@RequestScoped
public class ManufacturerWelcomeController {

    private static final Logger LOG = Logger.getLogger(ManufacturerWelcomeController.class.getName());
    
    @Inject
    private CarService carService;
    
    @EJB 
    ManufacturerService ManufacturerService;
    
    @Inject 
    LoginController loginController;
    
    private Manufacturer Manufacturer;

    /**
     * Initializes the ManufacturerWelcomeController after construction.
     */
    public ManufacturerWelcomeController()  {
    }

    /**
     * Performs initialization tasks after construction, such as retrieving the authenticated manufacturer's details.
     */
    @PostConstruct
    private void postConstruct() {
        LOG.info("ManufacturerWelcomeController.postConstruct");
        Manufacturer = ManufacturerService.findByUsername(loginController.getAuthenticatedUser());
        LOG.info("ManufacturerWelcomeController.postConstruct: " + Manufacturer.toString());
    }
    
    /**
     * Refreshes the manufacturer model by retrieving the latest details of the authenticated manufacturer.
     */
    public void refreshManufacturerModel(){
        Manufacturer = ManufacturerService.findByUsername(loginController.getAuthenticatedUser());
    }
    
    /**
     * Gets the authenticated manufacturer.
     * 
     * @return The authenticated manufacturer.
     */
    public Manufacturer getManufacturer() {
        return Manufacturer;
    }

    /**
     * Sets the authenticated manufacturer.
     * 
     * @param Manufacturer The authenticated manufacturer to set.
     */
    public void setManufacturer(Manufacturer Manufacturer) {
        this.Manufacturer = Manufacturer;
    }
}

