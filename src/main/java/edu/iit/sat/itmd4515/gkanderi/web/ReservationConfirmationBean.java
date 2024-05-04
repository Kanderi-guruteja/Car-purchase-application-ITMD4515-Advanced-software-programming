package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Reservation;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class ReservationConfirmationBean implements Serializable {

    private String logMessage;

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    private Reservation reservation;

    public ReservationConfirmationBean() {
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
