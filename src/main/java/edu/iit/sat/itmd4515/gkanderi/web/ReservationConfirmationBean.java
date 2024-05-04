package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Reservation;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * The ReservationConfirmationBean class manages the reservation confirmation details.
 * It holds the log message and reservation information.
 * 
 * @author 18722
 */
@Named
@SessionScoped
public class ReservationConfirmationBean implements Serializable {

    private String logMessage;
    private Reservation reservation;

    /**
     * Gets the log message.
     * 
     * @return The log message.
     */
    public String getLogMessage() {
        return logMessage;
    }

    /**
     * Sets the log message.
     * 
     * @param logMessage The log message to set.
     */
    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    /**
     * Gets the reservation.
     * 
     * @return The reservation.
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * Sets the reservation.
     * 
     * @param reservation The reservation to set.
     */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
