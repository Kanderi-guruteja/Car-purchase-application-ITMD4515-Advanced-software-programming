/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author 18722
 */

@Named
@RequestScoped
public class ManufacturerWelcomeController {

    private static final Logger LOG = Logger.getLogger(ManufacturerWelcomeController.class.getName());
    @Inject
    private CarService carService;
    @EJB ManufacturerService ManufacturerService;
    @Inject LoginController loginController;
    private Manufacturer Manufacturer;

    public ManufacturerWelcomeController()  {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("OwnerWelcomeController.postConstruct");
        Manufacturer = ManufacturerService.findByUsername(loginController.getAuthenticatedUser());
        LOG.info("OwnerWelcomeController.postConstruct: " + Manufacturer.toString());
    }
    public Manufacturer getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(Manufacturer Manufacturer) {
        this.Manufacturer = Manufacturer;
    }
}
