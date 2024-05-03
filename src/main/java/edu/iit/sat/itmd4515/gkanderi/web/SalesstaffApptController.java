package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Appointment;
import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.Manufacturer;
import edu.iit.sat.itmd4515.gkanderi.domain.Salesstaff;
import edu.iit.sat.itmd4515.gkanderi.service.AppointmentService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class SalesstaffApptController {

    private static final Logger LOG = Logger.getLogger(SalesstaffApptController.class.getName());

    private Appointment appt;

    @Inject
    SalesstaffWelcomeController swc;
    
    @EJB AppointmentService AppointmentService;
    
    public SalesstaffApptController(){
        
    }

    @PostConstruct
    public void postConstruct() {
        LOG.info("Inside SalesstaffApptController postConstruct");
        appt = new Appointment();
        appt.setCar(new Car());
        appt.setManufacturer(new Manufacturer());
        appt.setSalesstaff(swc.getSalesstaff());
    }

    public String displayViewApptPage(Appointment appt) {
        this.appt = appt;
        LOG.info("Inside SalesstaffApptController displayViewApptPage with " + appt.toString());
        return "/salesstaff/readAppt.xhtml";
    }

    public String displayEditApptPage(Appointment appt) {
        this.appt = appt;
        LOG.info("Inside SalesstaffApptController displayEditApptPage with " + appt.toString());
        return "/salesstaff/welcome.xhtml";
    }

    public String displayDeleteApptPage(Appointment appt) {
        this.appt = appt;
        LOG.info("Inside SalesstaffApptController displayDeleteApptPage with " + appt.toString());
        return "/salesstaff/welcome.xhtml";
    }

    public String displayScheduleApptPage(Car c) {
    appt.setCar(c);
    LOG.info("Inside SalesstaffApptController displayScheduleApptPage with " + appt.toString());
    return "/salesstaff/schedAppt.xhtml";
}

    public String scheduleAppointment() {
        LOG.info("Inside SalesstaffApptController scheduleAppointment with " + appt.toString());
        AppointmentService.scheduleAppointment(appt);
        swc.refreshSalesstaffModel();
        return "/salesstaff/welcome.xhtml";
    }

    public Appointment getAppt() {
        return appt;
    }

    public void setAppt(Appointment appt) {
        this.appt = appt;
    }
}
