/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 18722
 */
@Entity
@NamedQuery(name ="Appointment.findAll", query ="select a FROM Appointment a")
public class Appointment extends AbstractEntity{

   
    @Column(name = "APPT_DATE")
    private LocalDate date;
    @Column(name = "APPT_TIME")
    private LocalTime time;

    
    @ManyToOne
    @JoinColumn(name = "MANUFACTURER_ID")
    private Manufacturer manufacturer;

   
    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "SALESSTAFF_ID")
    private Salesstaff salesstaff;
    
    @ManyToMany
    @JoinTable(
    name = "CAR_APPOINTMENT",
    joinColumns = @JoinColumn(name = "APPOINTMENT_ID"),
    inverseJoinColumns = @JoinColumn(name = "CAR_ID")
)
private List<Car> cars = new ArrayList<>();
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
    public void  schedAppt (Manufacturer m, Car c, Salesstaff s){
        this.manufacturer= m;
        this.car= c;
        this.salesstaff= s;
        
        if(!m.getAppointments().contains(this)){
        m.getAppointments().add(this);
        }
        if(!c.getAppointments().contains(this)){
        s.getAppointments().add(this);
        }
}
    public void cancelappointment(){
        if(this.manufacturer.getAppointments().contains(this)){
        this.manufacturer.getAppointments().remove(this);
}
        if(this.salesstaff.getAppointments().contains(this)){
        this.salesstaff.getAppointments().remove(this);
        }
        this.manufacturer=null;
        this.car=null;
        this.salesstaff=null;
    }
    @Override
    public String toString() {
        return "Appointment{" + "Id=" + id + ", date=" + date + ", time=" + time + '}';
    
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
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

        if (this.id == null || other.id == null) {
            return false;
        }
        return Objects.equals(this.id, other.id);
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

    
}
