/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Entity class representing a reservation.
 */
@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Car car;
    
    private LocalTime reservationTime;
    private LocalDate reservationDate;

    /**
     * Gets the ID of the reservation.
     *
     * @return the ID of the reservation
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the reservation.
     *
     * @param id the ID of the reservation
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the car associated with the reservation.
     *
     * @return the car associated with the reservation
     */
    public Car getCar() {
        return car;
    }

    /**
     * Sets the car associated with the reservation.
     *
     * @param car the car associated with the reservation
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Gets the date of the reservation.
     *
     * @return the date of the reservation
     */
    public LocalDate getReservationDate() {
        return reservationDate;
    }

    /**
     * Sets the date of the reservation.
     *
     * @param reservationDate the date of the reservation
     */
    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    /**
     * Gets the time of the reservation.
     *
     * @return the time of the reservation
     */
    public LocalTime getReservationTime() {
        return reservationTime;
    }

    /**
     * Sets the time of the reservation.
     *
     * @param reservationTime the time of the reservation
     */
    public void setReservationTime(LocalTime reservationTime) {
        this.reservationTime = reservationTime;
    }
}
