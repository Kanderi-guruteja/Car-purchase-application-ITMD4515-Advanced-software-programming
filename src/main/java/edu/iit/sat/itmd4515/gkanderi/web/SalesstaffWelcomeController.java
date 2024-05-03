/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Salesstaff;
import edu.iit.sat.itmd4515.gkanderi.service.CarService;
import edu.iit.sat.itmd4515.gkanderi.service.SalesstaffService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author 18722
 */

@Named
@RequestScoped
public class SalesstaffWelcomeController {

    private static final Logger LOG = Logger.getLogger(SalesstaffWelcomeController.class.getName());
   
    @Inject
    private CarService carService;
    
    @EJB SalesstaffService SalesstaffService;
    
    @Inject LoginController loginController;
    private Salesstaff Salesstaff;

    public SalesstaffWelcomeController()  {
    }

    @PostConstruct
public void postConstruct() {
    LOG.info("SalesstaffWelcomeController.postConstruct");
    String username = loginController.getAuthenticatedUser();
    if (username != null) {
        List<Salesstaff> allSalesstaff = SalesstaffService.findAll();
        for (Salesstaff staff : allSalesstaff) {
            if (username.equals(staff.getUser().getUserName())) {
                Salesstaff = staff;
                LOG.info("SalesstaffWelcomeController.postConstruct: " + Salesstaff.toString());
                return; // Found the sales staff, exit the loop
            }
        }
        LOG.warning("Sales staff not found for username: " + username);
    } else {
        LOG.warning("Authenticated user not found!");
    }
}

public void refreshSalesstaffModel() {
    LOG.info("Refreshing Salesstaff model...");
    String username = loginController.getAuthenticatedUser();
    if (username != null) {
        List<Salesstaff> allSalesstaff = SalesstaffService.findAll();
        for (Salesstaff staff : allSalesstaff) {
            if (username.equals(staff.getUser().getUserName())) {
                Salesstaff = staff;
                LOG.info("SalesstaffWelcomeController.refreshSalesstaffModel: " + Salesstaff.toString());
                return; // Found the sales staff, exit the loop
            }
        }
        LOG.warning("Sales staff not found for username: " + username);
    } else {
        LOG.warning("Authenticated user not found!");
    }
}

    
    
    
    public Salesstaff getSalesstaff(){
        return Salesstaff;
    }

    public void setSalesstaff(Salesstaff Salesstaff) {
        this.Salesstaff = Salesstaff;
    }
}

