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
 *
 * @author 18722
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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Manufacturer> getManufacturer() {
        return manufacturers;
    }

    public void setManufacturer(List<Manufacturer> manufacturer) {
        this.manufacturers = manufacturer;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Car other = (Car) obj;

        if (this.id == null || other.id == null) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", name=" + name + ", buyDate=" + buyDate + ", type=" + type + '}';
    }

    public Car() {
    }

    public Car(String name, LocalDate buyDate, CarType type) {
        this.name = name;
        this.buyDate = buyDate;
        this.type = type;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public LocalDate getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(LocalDate buyDate) {
        this.buyDate = buyDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
