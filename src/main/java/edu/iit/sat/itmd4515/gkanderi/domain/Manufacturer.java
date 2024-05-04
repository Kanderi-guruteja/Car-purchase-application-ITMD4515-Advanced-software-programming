/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;

import edu.iit.sat.itmd4515.gkanderi.security.User;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entity class representing a manufacturer.
 */
@Entity
@NamedQuery(name = "Manufacturer.findAll", query = "select m from Manufacturer m")
@NamedQuery(name = "Manufacturer.findByUsername", query="select m from Manufacturer m where m.user.userName = :uname")
public class Manufacturer extends AbstractNamedEntity {

    @Column(name = "MANUFACTURER_EMAIL")
    private String email;

    @Column(name = "MANUFACTURER_MAKEDATE")
    private LocalDate makeDate;

    @OneToMany(mappedBy = "manufacturer")
    private List<Appointment> appointments = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    @ManyToMany
    @JoinTable(name = "MANUFACTURER_CARS",
            joinColumns = @JoinColumn(name = "MANUFACTURER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CAR_ID"))
    private List<Car> cars = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "LEASINGOFFICE_ID")
    private Leasingoffice leasingoffice;

    /**
     * Constructs a new instance of the manufacturer.
     */
    public Manufacturer() {
    }

    /**
     * Constructs a new instance of the manufacturer with the specified email, name, and make date.
     *
     * @param email    the email of the manufacturer
     * @param name     the name of the manufacturer
     * @param makeDate the make date of the manufacturer
     */
    public Manufacturer(String email, String name, LocalDate makeDate) {
        this.email = email;
        this.name = name;
        this.makeDate = makeDate;
    }

    /**
     * Gets the email of the manufacturer.
     *
     * @return the email of the manufacturer
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the manufacturer.
     *
     * @param email the email of the manufacturer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the make date of the manufacturer.
     *
     * @return the make date of the manufacturer
     */
    public LocalDate getMakeDate() {
        return makeDate;
    }

    /**
     * Sets the make date of the manufacturer.
     *
     * @param makeDate the make date of the manufacturer
     */
    public void setMakeDate(LocalDate makeDate) {
        this.makeDate = makeDate;
    }

    /**
     * Gets the list of appointments associated with this manufacturer.
     *
     * @return the list of appointments associated with this manufacturer
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Sets the list of appointments associated with this manufacturer.
     *
     * @param appointments the list of appointments associated with this manufacturer
     */
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     * Gets the list of cars associated with this manufacturer.
     *
     * @return the list of cars associated with this manufacturer
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * Sets the list of cars associated with this manufacturer.
     *
     * @param cars the list of cars associated with this manufacturer
     */
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * Gets the leasing office associated with this manufacturer.
     *
     * @return the leasing office associated with this manufacturer
     */
    public Leasingoffice getLeasingoffice() {
        return leasingoffice;
    }

    /**
     * Sets the leasing office associated with this manufacturer.
     *
     * @param leasingoffice the leasing office associated with this manufacturer
     */
    public void setLeasingoffice(Leasingoffice leasingoffice) {
        this.leasingoffice = leasingoffice;
    }

    /**
     * Gets the user associated with this manufacturer.
     *
     * @return the user associated with this manufacturer
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with this manufacturer.
     *
     * @param user the user associated with this manufacturer
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Adds a car to this manufacturer.
     *
     * @param car the car to add
     */
    public void addCar(Car car) {
        if (!this.cars.contains(car)) {
            this.cars.add(car);
            car.getManufacturer().add(this);
        }
    }

    /**
     * Removes a car from this manufacturer.
     *
     * @param car the car to remove
     */
    public void removeCar(Car car) {
        if (this.cars.contains(car)) {
            this.cars.remove(car);
            car.getManufacturer().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Manufacturer{" + "id=" + id + ", email=" + email + ", name=" + name + ", makeDate=" + makeDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Manufacturer other = (Manufacturer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
