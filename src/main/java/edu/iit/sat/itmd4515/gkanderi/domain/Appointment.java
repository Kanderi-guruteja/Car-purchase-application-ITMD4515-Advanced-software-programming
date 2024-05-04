/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Appointment class represents an appointment entity.
 * It contains information such as date, time, manufacturer, car, and sales staff associated with the appointment.
 */
@Entity
@NamedQuery(name = "Appointment.findAll", query = "select a FROM Appointment a")
public class Appointment extends AbstractEntity {

    @FutureOrPresent
    @Column(name = "APPT_DATE")
    private LocalDate date;

    @Column(name = "APPT_TIME")
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "MANUFACTURER_ID", nullable = true)
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "CAR_ID", nullable = true)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "SALESSTAFF_ID", nullable = true)
    private Salesstaff salesstaff;

    @ManyToMany
    @JoinTable(
            name = "CAR_APPOINTMENT",
            joinColumns = @JoinColumn(name = "APPOINTMENT_ID", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "CAR_ID", nullable = true)
    )
    private List<Car> cars = new ArrayList<>();

    /**
     * Get the sales staff associated with the appointment.
     *
     * @return the sales staff associated with the appointment
     */
    public Salesstaff getSalesstaff() {
        return salesstaff;
    }

    /**
     * Set the sales staff associated with the appointment.
     *
     * @param salesstaff the new sales staff associated with the appointment
     */
    public void setSalesstaff(Salesstaff salesstaff) {
        this.salesstaff = salesstaff;
    }

    /**
     * Get the car associated with the appointment.
     *
     * @return the car associated with the appointment
     */
    public Car getCar() {
        return car;
    }

    /**
     * Set the car associated with the appointment.
     *
     * @param car the new car associated with the appointment
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Get the manufacturer associated with the appointment.
     *
     * @return the manufacturer associated with the appointment
     */
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    /**
     * Set the manufacturer associated with the appointment.
     *
     * @param manufacturer the new manufacturer associated with the appointment
     */
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Constructs an appointment with the specified date and time.
     *
     * @param date the date of the appointment
     * @param time the time of the appointment
     */
    public Appointment(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }

    /**
     * Constructs an appointment with default date and time.
     */
    public Appointment() {
    }

    /**
     * Schedule an appointment with the specified manufacturer, car, and sales staff.
     *
     * @param m the manufacturer for the appointment
     * @param c the car for the appointment
     * @param s the sales staff for the appointment
     */
    public void schedAppt(Manufacturer m, Car c, Salesstaff s) {
        this.manufacturer = m;
        this.car = c;
        this.salesstaff = s;

        if (!m.getAppointments().contains(this)) {
            m.getAppointments().add(this);
        }
        if (!c.getAppointments().contains(this)) {
            s.getAppointments().add(this);
        }
    }

    /**
     * Cancel the appointment.
     */
    public void cancelappointment() {
        if (this.manufacturer.getAppointments().contains(this)) {
            this.manufacturer.getAppointments().remove(this);
        }
        if (this.salesstaff.getAppointments().contains(this)) {
            this.salesstaff.getAppointments().remove(this);
        }
        this.manufacturer = null;
        this.car = null;
        this.salesstaff = null;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Appointment{" + "Id=" + id + ", date=" + date + ", time=" + time + manufacturer.getId() + car.getId() + salesstaff.getId() + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Appointment other = (Appointment) obj;

        if (this.id == null || other.id == null) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     * Get the time of the appointment.
     *
     * @return the time of the appointment
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Set the time of the appointment.
     *
     * @param time the new time of the appointment
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * Get the date of the appointment.
     *
     * @return the date of the appointment
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Set the date of the appointment.
     *
     * @param date the new date of the appointment
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

}
