/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author 18722
 */
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APPT_ID")
    private Long Id;
    @Column(name = "APPT_DATE")
    private LocalDate date;
    @Column(name = "APPT_TIME")
    private LocalTime time;

    /**
     * 1 to many / many to 1 bidirectional
     *  ManyToOne is always the owning side
     * Appointment is the owner of this relationship
     */
    @ManyToOne
    @JoinColumn(name = "MANUFACTURER_ID")
    private Manufacturer manufacturer;

    /**
     *  many to 1 uni-directional
     * Appointment is the owning and only side of this relationship
     */
    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;

    /**
     * 1 to many / many to 1 bidirectional
     * ManyToOne is always the owning side
     * Appointment is the owner of this relationship
     */
    @ManyToOne
    @JoinColumn(name = "SALESSTAFF_ID")
    private Salesstaff salesstaff;

    /**
     * Get the value of salesstaff
     *
     * @return the value of salesstaff
     */
    public Salesstaff getSalesstaff() {
        return salesstaff;
    }

    /**
     * Set the value of salesstaff
     *
     * @param salesstaff new value of salesstaff
     */
    public void setSalesstaff(Salesstaff salesstaff) {
        this.salesstaff = salesstaff;
    }

    /**
     * Get the value of car
     *
     * @return the value of car
     */
    public Car getCar() {
        return car;
    }

    /**
     * Set the value of car
     *
     * @param car new value of car
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Get the value of manufacturer
     *
     * @return the value of manufacturer
     */
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    /**
     * Set the value of manufacturer
     *
     * @param manufacturer new value of manufacturer
     */
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Appointment(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }

    public Appointment() {
    }

    @Override
    public String toString() {
        return "Appointment{" + "Id=" + Id + ", date=" + date + ", time=" + time + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.Id);
        return hash;
    }

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

        if (this.Id == null || other.Id == null) {
            return false;
        }
        return Objects.equals(this.Id, other.Id);
    }

    /**
     * Get the value of time
     *
     * @return the value of time
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Set the value of time
     *
     * @param time new value of time
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * Get the value of date
     *
     * @return the value of date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Set the value of date
     *
     * @param date new value of date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Get the value of Id
     *
     * @return the value of Id
     */
    public Long getId() {
        return Id;
    }

    /**
     * Set the value of Id
     *
     * @param Id new value of Id
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

}

//Finsihed appointment
