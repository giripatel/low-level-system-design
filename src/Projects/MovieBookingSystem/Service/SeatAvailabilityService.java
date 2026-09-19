package Projects.MovieBookingSystem.Service;

import Projects.MovieBookingSystem.Interfaces.ISeatLockProvider;
import Projects.MovieBookingSystem.UtilityPackage.Seat;
import Projects.MovieBookingSystem.UtilityPackage.Show;

import java.util.ArrayList;
import java.util.List;

public class SeatAvailabilityService {
    BookingService bookingService;
    ISeatLockProvider seatLockProvider;

    public SeatAvailabilityService(BookingService bookingService, ISeatLockProvider seatLockProvider) {
        this.bookingService = bookingService;
        this.seatLockProvider = seatLockProvider;
    }

    public List<Seat> getAvailableSeats(Show show) {
        return new ArrayList<>();
    }

    public List<Seat> getUnavailableSeats(Show show) {
        return new ArrayList<>();
    }
}
