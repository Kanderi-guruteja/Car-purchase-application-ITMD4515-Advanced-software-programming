package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Appointment;
import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.Salesstaff;
import edu.iit.sat.itmd4515.gkanderi.service.AppointmentService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.logging.Logger;

/**
 * The ManufacturerApptController class manages appointments for manufacturers in the web application.
 * It provides methods for displaying, editing, deleting, and scheduling appointments.
 * 
 * @author 18722
 */
@Named
@RequestScoped
public class ManufacturerApptController {

    private static final Logger LOG = Logger.getLogger(ManufacturerApptController.class.getName());

    private Appointment appt;

    @Inject
    ManufacturerWelcomeController mwc;

    @EJB
    AppointmentService AppointmentService;

    /**
     * Initializes the ManufacturerApptController after construction.
     */
    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside ManufacturerApptController postConstruct");
        appt = new Appointment();
        appt.setCar(new Car());
        appt.setSalesstaff(new Salesstaff());
        appt.setManufacturer(mwc.getManufacturer());
    }

    /**
     * Displays the view appointment page for a given appointment.
     * 
     * @param appt The appointment to display.
     * @return The outcome page.
     */
    public String displayViewApptPage(Appointment appt) {
        this.appt = appt;
        LOG.info("Inside ManufacturerApptController displayViewApptPage with " + appt.toString());
        return "/manufacturer/welcome.xhtml";
    }

    /**
     * Displays the edit appointment page for a given appointment.
     * 
     * @param appt The appointment to edit.
     * @return The outcome page.
     */
    public String displayEditApptPage(Appointment appt) {
        this.appt = appt;
        LOG.info("Inside ManufacturerApptController displayEditApptPage with " + appt.toString());
        return "/manufacturer/welcome.xhtml";
    }

    /**
     * Displays the delete appointment page for a given appointment.
     * 
     * @param appt The appointment to delete.
     * @return The outcome page.
     */
    public String displayDeleteApptPage(Appointment appt) {
        this.appt = appt;
        LOG.info("Inside ManufacturerApptController displayDeleteApptPage with " + appt.toString());
        return "/manufacturer/welcome.xhtml";
    }

    /**
     * Displays the schedule appointment page for a given car.
     * 
     * @param c The car for which to schedule the appointment.
     * @return The outcome page.
     */
    public String displayScheduleApptPage(Car c) {
        appt.setCar(c);
        LOG.info("Inside ManufacturerApptController displayScheduleApptPage with " + appt.toString());
        return "/manufacturer/schedAppt.xhtml";
    }

    /**
     * Schedules the appointment.
     * 
     * @return The outcome page after scheduling the appointment.
     */
    public String scheduleAppointment() {
        LOG.info("Inside ManufacturerApptController scheduleAppointment with " + appt.toString());
        AppointmentService.scheduleAppointment(appt);
        mwc.refreshManufacturerModel();
        return "/manufacturer/welcome.xhtml";
    }

    /**
     * Retrieves the appointment.
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
