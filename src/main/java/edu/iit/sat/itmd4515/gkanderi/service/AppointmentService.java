/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Appointment;
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
}
