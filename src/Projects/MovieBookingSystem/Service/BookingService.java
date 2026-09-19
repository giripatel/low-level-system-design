package Projects.MovieBookingSystem.Service;

import Projects.MovieBookingSystem.Interfaces.ISeatLockProvider;
import Projects.MovieBookingSystem.UtilityPackage.Booking;
import Projects.MovieBookingSystem.UtilityPackage.Seat;
import Projects.MovieBookingSystem.UtilityPackage.Show;
import Projects.MovieBookingSystem.UtilityPackage.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingService {
    Map<String, Booking> showBookings;
    ISeatLockProvider seatLockProvider;
    AtomicInteger bookingCounter;

    public BookingService(ISeatLockProvider seatLockProvider) {
        this.seatLockProvider = seatLockProvider;
        this.bookingCounter = new AtomicInteger(0);
        this.showBookings = new ConcurrentHashMap<>();
    }

    public Booking getBooking(String bookingId) throws Exception {
        if (!showBookings.containsKey(bookingId)) {
            throw new Exception("Booking with Id: " + bookingId + " not found");
        }
        return showBookings.get(bookingId);
    }

    public List<Booking> getAllBookings(Show show) {
        List<Booking> response = new ArrayList<>();
        for (Booking booking: showBookings.values()) {
            if (booking.getShow().equals(show)) {
                response.add(booking);
            }
        }
        return response;
    }

    public Booking createBooking(User user, Show show, List<Seat> seats) throws Exception {
            if (isAnySeatAlreadyBooked(show, seats))
                throw new Exception("Seat is already booked");

            seatLockProvider.lockSeats(show, seats, user);
        System.out.println("Locked seats");
            String bookingId = String.valueOf(bookingCounter.incrementAndGet());
            Booking newBooking = new Booking(bookingId, show, user, seats);
            showBookings.put(bookingId, newBooking);
            return newBooking;
    }

    public void confirmBooking(Booking booking, User user) throws Exception {
        if (!booking.getUser().equals(user)) {
            throw new Exception("Cannot confirm a Booking made by another user");
        }

        // Validate locks for each seat
        for (Seat seat: booking.getSeatsBooked()) {
            if (!seatLockProvider.validateLock(booking.getShow(), seat, user)) {
                throw new Exception("Acquired Lock is either invalid or has expired");
            }
        }

        System.out.println("Confirming seats");
        booking.confirmBooking();
    }
    public List<Seat> getBookedSeats(Show show) {
        List<Seat> bookedSeats = new ArrayList<>();
        for (Booking booking: getAllBookings(show)) {
            if (booking.isConfirmed()) {
                bookedSeats.addAll(booking.getSeatsBooked());
            }
        }

        return bookedSeats;
    }

    public boolean isAnySeatAlreadyBooked(Show show, List<Seat> seats) {
        List<Seat> bookedSeats = getBookedSeats(show);

        for (Seat seat: seats) {
            if (bookedSeats.contains(seat)) return true;
        }
        return false;
    }
}
