package Projects.MovieBookingSystem.Controller;

import Projects.MovieBookingSystem.Service.BookingService;
import Projects.MovieBookingSystem.Service.ShowService;
import Projects.MovieBookingSystem.Service.TheatreService;
import Projects.MovieBookingSystem.UtilityPackage.Booking;
import Projects.MovieBookingSystem.UtilityPackage.Seat;
import Projects.MovieBookingSystem.UtilityPackage.Show;
import Projects.MovieBookingSystem.UtilityPackage.User;

import java.util.ArrayList;
import java.util.List;

public class BookingController {
    private ShowService showService;
    private BookingService bookingService;
    private TheatreService theatreService;

    public BookingController(ShowService showService, BookingService bookingService, TheatreService theatreService) {
        this.showService = showService;
        this.bookingService = bookingService;
        this.theatreService = theatreService;
    }

    public String createBooking(int showId, User user, List<Integer> seatIds) throws Exception {
        Show show = showService.getShow(showId);
        List<Seat> seats = new ArrayList<>();
        for (int seatId : seatIds) {
            seats.add(theatreService.getSeat(seatId));
        }
        Booking booking = bookingService.createBooking(user, show, seats);
        return booking.getId();
    }

}
