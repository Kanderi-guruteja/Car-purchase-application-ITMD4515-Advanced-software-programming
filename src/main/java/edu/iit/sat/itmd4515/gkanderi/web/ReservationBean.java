package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.Reservation;
import edu.iit.sat.itmd4515.gkanderi.service.CarService;
import edu.iit.sat.itmd4515.gkanderi.service.ReservationService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.time.LocalDate;
import java.time.LocalTime;

@Named
@RequestScoped
public class ReservationBean {

    @Inject
    private CarService carService;

    @Inject
    private ReservationService reservationService;

    @Inject
    private DefaultWelcomeController defaultWelcomeController;

    @Inject
    private ReservationConfirmationBean reservationConfirmationBean;

    private Long selectedCarId;
    private LocalDate reservationDate;
    private LocalTime reservationTime;

    private boolean reservationMade;

    public boolean isReservationMade() {
        return reservationMade;
    }

    public void setReservationMade(boolean reservationMade) {
        this.reservationMade = reservationMade;
    }

    public Long getSelectedCarId() {
        return selectedCarId;
    }

    public void setSelectedCarId(Long selectedCarId) {
        this.selectedCarId = selectedCarId;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String reserveCar() {
        Car selectedCar = defaultWelcomeController.getAvailableCars().stream()
                .filter(car -> car.getId().equals(selectedCarId))
                .findFirst()
                .orElse(null);

        if (selectedCar != null) {
            Reservation reservation = new Reservation();
            reservation.setCar(selectedCar);
            reservationService.create(reservation);

            // Store the reservation object in the session with the key "reservation"
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("reservation", reservation);

            // Set the log message using the injected instance of ReservationConfirmationBean
            reservationConfirmationBean.setLogMessage("Reservation details saved successfully.");

            // Set the reservationMade flag to true
            reservationMade = true;

            return "/reservationconfirmation.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Selected car not found."));
            return null;
        }
    }
}
