/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Car class represents a car entity.
 * It contains information such as name, purchase date, and type of the car.
 */
@Entity
@Table(name = "CAR")
@NamedQuery(name = "Car.findAll", query = "select p from Car p")
public class Car extends AbstractEntity {

    @NotBlank
    @Column(name = "Car_NAME", nullable = false, unique = true)
    private String name;

    @PastOrPresent
    @Column(name = "Car_BUYDAY")
    private LocalDate buyDate;

    @Column(name = "Car_Type")
    @NotNull
    @Enumerated(EnumType.STRING)
    private CarType type;

    @ManyToMany(mappedBy = "cars")
    private List<Manufacturer> manufacturers = new ArrayList<>();

    @ManyToMany(mappedBy = "cars")
    private List<Appointment> appointments = new ArrayList<>();

    /**
     * Get the list of appointments associated with the car.
     *
     * @return the list of appointments associated with the car
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Set the list of appointments associated with the car.
     *
     * @param appointments the new list of appointments associated with the car
     */
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     * Get the list of manufacturers associated with the car.
     *
     * @return the list of manufacturers associated with the car
     */
    public List<Manufacturer> getManufacturer() {
        return manufacturers;
    }

    /**
     * Set the list of manufacturers associated with the car.
     *
     * @param manufacturer the new list of manufacturers associated with the car
     */
    public void setManufacturer(List<Manufacturer> manufacturer) {
        this.manufacturers = manufacturer;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Car other = (Car) obj;

        if (this.id == null || other.id == null) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", name=" + name + ", buyDate=" + buyDate + ", type=" + type + '}';
    }

    /**
     * Constructs a car with default values.
     */
    public Car() {
    }

    /**
     * Constructs a car with the specified name, purchase date, and type.
     *
     * @param name the name of the car
     * @param buyDate the purchase date of the car
     * @param type the type of the car
     */
    public Car(String name, LocalDate buyDate, CarType type) {
        this.name = name;
        this.buyDate = buyDate;
        this.type = type;
    }

    /**
     * Get the type of the car.
     *
     * @return the type of the car
     */
    public CarType getType() {
        return type;
    }

    /**
     * Set the type of the car.
     *
     * @param type the new type of the car
     */
    public void setType(CarType type) {
        this.type = type;
    }

    /**
     * Get the purchase date of the car.
     *
     * @return the purchase date of the car
     */
    public LocalDate getBuyDate() {
        return buyDate;
    }

    /**
     * Set the purchase date of the car.
     *
     * @param buyDate the new purchase date of the car
     */
    public void setBuyDate(LocalDate buyDate) {
        this.buyDate = buyDate;
    }

    /**
     * Get the name of the car.
     *
     * @return the name of the car
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the car.
     *
     * @param name the new name of the car
     */
    public void setName(String name) {
        this.name = name;
    }
}
