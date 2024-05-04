package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.Reservation;
import edu.iit.sat.itmd4515.gkanderi.service.CarService;
import edu.iit.sat.itmd4515.gkanderi.service.ReservationService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Logger;

/**
 * The ReservationBean class manages the reservation process.
 * It retrieves the user's reservations, allows them to reserve a car, and provides a method to initialize the bean.
 * 
 * @author 18722
 */
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

    private List<Reservation> userReservations;

    private Long selectedCarId;
    private LocalDate reservationDate;
    private LocalTime reservationTime;

    private boolean reservationMade;

    /**
     * Initializes the ReservationBean after construction.
     */
    @PostConstruct
    public void init() {
        // Fetch the user's reservations from the database or session
        userReservations = reservationService.getAllReservations(); // Assuming you have a method to get all reservations
        
        // Log the retrieved reservations
        Logger.getLogger(ReservationBean.class.getName()).info("Retrieved " + userReservations.size() + " reservations.");
    }

    /**
     * Gets the user's reservations.
     * 
     * @return The list of user reservations.
     */
    public List<Reservation> getUserReservations() {
        return userReservations;
    }

    /**
     * Sets the user's reservations.
     * 
     * @param userReservations The list of user reservations to set.
     */
    public void setUserReservations(List<Reservation> userReservations) {
        this.userReservations = userReservations;
    }

    /**
     * Gets the ID of the selected car.
     * 
     * @return The ID of the selected car.
     */
    public Long getSelectedCarId() {
        return selectedCarId;
    }

    /**
     * Sets the ID of the selected car.
     * 
     * @param selectedCarId The ID of the selected car to set.
     */
    public void setSelectedCarId(Long selectedCarId) {
        this.selectedCarId = selectedCarId;
    }

    /**
     * Gets the reservation date.
     * 
     * @return The reservation date.
     */
    public LocalDate getReservationDate() {
        return reservationDate;
    }

    /**
     * Sets the reservation date.
     * 
     * @param reservationDate The reservation date to set.
     */
    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    /**
     * Gets the reservation time.
     * 
     * @return The reservation time.
     */
    public LocalTime getReservationTime() {
        return reservationTime;
    }

    /**
     * Sets the reservation time.
     * 
     * @param reservationTime The reservation time to set.
     */
    public void setReservationTime(LocalTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    /**
     * Checks if a reservation has been made.
     * 
     * @return true if a reservation has been made, otherwise false.
     */
    public boolean isReservationMade() {
        return reservationMade;
    }

    /**
     * Sets the reservation made status.
     * 
     * @param reservationMade The reservation made status to set.
     */
    public void setReservationMade(boolean reservationMade) {
        this.reservationMade = reservationMade;
    }

    /**
     * Reserves a car based on the selected car ID and sets the reservation details.
     * 
     * @return The navigation outcome for the reservation confirmation page.
     */
    public String reserveCar() {
        Car selectedCar = defaultWelcomeController.getAvailableCars().stream()
                .filter(car -> car.getId().equals(selectedCarId))
                .findFirst()
                .orElse(null);

        if (selectedCar != null) {
            Reservation reservation = new Reservation();
            reservation.setCar(selectedCar);

            // Set reservation date and time
            reservation.setReservationDate(LocalDate.now());
            reservation.setReservationTime(LocalTime.now());

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
