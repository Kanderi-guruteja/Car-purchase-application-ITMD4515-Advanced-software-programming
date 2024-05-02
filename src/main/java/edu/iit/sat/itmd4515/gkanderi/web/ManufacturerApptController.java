package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Appointment;
import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.Salesstaff;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class ManufacturerApptController {

    private static final Logger LOG = Logger.getLogger(ManufacturerApptController.class.getName());

    private Appointment appt;

    @Inject
    ManufacturerWelcomeController mwc;

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside ManufacturerApptController postConstruct");
        appt = new Appointment();
        appt.setCar(new Car());
        appt.setSalesstaff(new Salesstaff());
        appt.setManufacturer(mwc.getManufacturer());
    }

    public String displayViewApptPage(Appointment appt) {
        this.appt = appt;
        LOG.info("Inside ManufacturerApptController displayViewApptPage with " + appt.toString());
        return "manufacturer/welcome.xhtml";
    }

    public String displayEditApptPage(Appointment appt) {
        this.appt = appt;
        LOG.info("Inside ManufacturerApptController displayEditApptPage with " + appt.toString());
        return "manufacturer/welcome.xhtml";
    }

    public String displayDeleteApptPage(Appointment appt) {
        this.appt = appt;
        LOG.info("Inside ManufacturerApptController displayDeleteApptPage with " + appt.toString());
        return "manufacturer/welcome.xhtml";
    }

    public String displayScheduleApptPage(Car c) {
        appt.setCar(c);
        LOG.info("Inside ManufacturerApptController displayScheduleApptPage with " + appt.toString());
        return "manufacturer/schedAppt?faces-redirect=true";
    }

    public String scheduleAppointment() {
        LOG.info("Inside ManufacturerApptController scheduleAppointment with " + appt.toString());
        mwc.refreshManufacturerModel();
        return "manufacturer/welcome?faces-redirect=true";
    }

    public Appointment getAppt() {
        return appt;
    }

    public void setAppt(Appointment appt) {
        this.appt = appt;
    }
}
