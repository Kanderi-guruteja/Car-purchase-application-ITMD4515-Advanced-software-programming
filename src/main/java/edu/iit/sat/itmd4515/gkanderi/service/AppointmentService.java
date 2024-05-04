/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Appointment;
import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.Manufacturer;
import edu.iit.sat.itmd4515.gkanderi.domain.Salesstaff;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author 18722
 */
@Stateless
public class AppointmentService extends AbstractService<Appointment> {

    public AppointmentService() {
        super(Appointment.class);
    }

    public void create(Appointment appointment) {
        super.create(appointment);
    }

    public List<Appointment> findAll() {
        return super.findAll("Appointment.findAll");

    }

   public void scheduleAppointment(Appointment appt) {
    Appointment newAppt = new Appointment(appt.getDate(), appt.getTime());
    newAppt.schedAppt(
            em.getReference(Manufacturer.class, appt.getManufacturer().getId()), 
            em.getReference(Car.class, appt.getCar().getId()), 
            em.getReference(Salesstaff.class, appt.getSalesstaff().getId())
    );
    em.persist(newAppt);
    appt.setId(newAppt.getId());
}
}