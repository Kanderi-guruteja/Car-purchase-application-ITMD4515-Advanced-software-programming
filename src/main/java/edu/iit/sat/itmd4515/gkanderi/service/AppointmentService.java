package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Appointment;
import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.Manufacturer;
import edu.iit.sat.itmd4515.gkanderi.domain.Salesstaff;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 * A service class for managing appointments.
 * Extends the AbstractService class providing basic CRUD operations.
 * @author 18722
 */
@Stateless
public class AppointmentService extends AbstractService<Appointment> {

    /**
     * Constructs a new AppointmentService.
     * Initializes the service with the Appointment entity class.
     */
    public AppointmentService() {
        super(Appointment.class);
    }

    /**
     * Creates a new appointment in the database.
     * @param appointment The appointment to be created.
     */
    public void create(Appointment appointment) {
        super.create(appointment);
    }

    /**
     * Retrieves all appointments from the database.
     * @return A list of all appointments.
     */
    public List<Appointment> findAll() {
        return super.findAll("Appointment.findAll");
    }

    /**
     * Schedule a new appointment with the given details.
     * Creates a new appointment entity and persists it in the database.
     * @param appt The appointment details.
     */
   public void scheduleAppointment(Appointment appt) {
    // Create a new appointment with the provided date and time
    Appointment newAppt = new Appointment(appt.getDate(), appt.getTime());
    
    // Schedule the appointment with the manufacturer, car, and sales staff
    newAppt.schedAppt(
            em.getReference(Manufacturer.class, 1L), 
            em.getReference(Car.class, 1L), 
            em.getReference(Salesstaff.class, 1L)
    );
    
    // Persist the new appointment in the database
    em.persist(newAppt);
    
    // Update the ID of the original appointment with the ID of the newly created one
    appt.setId(newAppt.getId());
}

    /**
     *
     * @param appt
     */
    public void updateAppointment(Appointment appt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}