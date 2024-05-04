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

/**
 * The SalesstaffApptController class manages appointment-related operations for sales staff.
 * It handles displaying, editing, deleting, and scheduling appointments.
 * 
 * @author 18722
 */
@Named
@RequestScoped
public class SalesstaffApptController {

    private static final Logger LOG = Logger.getLogger(SalesstaffApptController.class.getName());
    private Appointment appt;

    @Inject
    SalesstaffWelcomeController swc;
    
    @EJB 
    AppointmentService appointmentService;
    
    /**
     * Default constructor for SalesstaffApptController.
     */
    public SalesstaffApptController(){
        
    }

    /**
     * Initializes the SalesstaffApptController after construction.
     */
    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside SalesstaffApptController postConstruct");
        appt = new Appointment();
        appt.setCar(new Car());
        appt.setManufacturer(new Manufacturer());
        appt.setSalesstaff(swc.getSalesstaff());
    }

    /**
     * Displays the view appointment page.
     * 
     * @param appt The appointment to view.
     * @return The view appointment page.
     */
    public String displayViewApptPage(Appointment appt) {
        this.appt = appt;
        LOG.info("Inside SalesstaffApptController displayViewApptPage with " + appt.toString());
        return "/salesstaff/readAppt.xhtml";
    }

    /**
     * Displays the edit appointment page.
     * 
     * @param appt The appointment to edit.
     * @return The edit appointment page.
     */
    public String displayEditApptPage(Appointment appt) {
        this.appt = appt;
        LOG.info("Inside SalesstaffApptController displayEditApptPage with " + appt.toString());
        return "/salesstaff/welcome.xhtml";
    }

    /**
     * Displays the delete appointment page.
     * 
     * @param appt The appointment to delete.
     * @return The delete appointment page.
     */
    public String displayDeleteApptPage(Appointment appt) {
        this.appt = appt;
        LOG.info("Inside SalesstaffApptController displayDeleteApptPage with " + appt.toString());
        return "/salesstaff/welcome.xhtml";
    }

    /**
     * Displays the schedule appointment page.
     * 
     * @param c The car for which the appointment is scheduled.
     * @return The schedule appointment page.
     */
    public String displayScheduleApptPage(Car c) {
        appt.setCar(c);
        LOG.info("Inside SalesstaffApptController displayScheduleApptPage with " + appt.toString());
        return "/salesstaff/schedAppt.xhtml";
    }

    /**
     * Schedules an appointment.
     * 
     * @return The welcome page for sales staff.
     */
    public String scheduleAppointment() {
        LOG.info("Inside SalesstaffApptController scheduleAppointment with Appointment{date=" + appt.toString());

        appointmentService.scheduleAppointment(appt);
        swc.refreshSalesstaffModel();
        return "/salesstaff/welcome.xhtml";
    }

    /**
     * Gets the appointment.
     * 
     * @return The appointment.
     */
    public Appointment getAppt() {
        return appt;
    }

    /**
     * Sets the appointment.
     * 
     * @param appt The appointment to set.
     */
    public void setAppt(Appointment appt) {
        this.appt = appt;
    }
}
