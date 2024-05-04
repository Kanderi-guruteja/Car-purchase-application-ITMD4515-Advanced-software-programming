package EJBMail;
import edu.iit.sat.itmd4515.gkanderi.domain.Reservation;
import edu.iit.sat.itmd4515.gkanderi.service.ReservationService;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.inject.Inject;
import java.util.List;

/**
 *
 * @author 18722
 */
@Singleton
public class ReservationReminderBean {

    @Inject
    private ReservationService reservationService;

    /**
     *
     */
    @Schedule(hour = "*/1", persistent = false) // Every hour
    public void sendReservationReminders() {
        List<Reservation> upcomingReservations = reservationService.getUpcomingReservations();
        // Logic to send reminders for upcoming reservations
    }
}
