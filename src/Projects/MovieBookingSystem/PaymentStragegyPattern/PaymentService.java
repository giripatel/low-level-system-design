package Projects.MovieBookingSystem.PaymentStragegyPattern;

import Projects.MovieBookingSystem.Service.BookingService;
import Projects.MovieBookingSystem.UtilityPackage.Booking;
import Projects.MovieBookingSystem.UtilityPackage.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PaymentService {
    private Map<Booking, Integer> bookingFailures;

    private PaymentStrategy paymentStrategy;
    private BookingService bookingService;

    public PaymentService(PaymentStrategy paymentStrategy, BookingService bookingService) {
        this.paymentStrategy = paymentStrategy;
        this.bookingService = bookingService;
        this.bookingFailures = new ConcurrentHashMap<>();
    }

    public void processPaymentFailed(String bookingId, User user) throws Exception {

        Booking booking = bookingService.getBooking(bookingId);

        if (!booking.getUser().equals(user)) {
            throw new Exception("Only the booking owner can report payment failure.");
        }

        bookingFailures.put(booking, bookingFailures.getOrDefault(booking, 0) + 1);
        System.out.println("Couldn't process payment for Booking with id " + bookingId);
    }

    public void processPayment(String bookingId, User user, double amount) throws Exception {
        if (paymentStrategy.processPayment(amount)) {
            bookingService.confirmBooking(bookingService.getBooking(bookingId), user);
        } else {
            processPaymentFailed(bookingId, user);
        }
    }
}
