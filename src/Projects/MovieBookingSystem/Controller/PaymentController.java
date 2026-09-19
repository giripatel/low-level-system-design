package Projects.MovieBookingSystem.Controller;

import Projects.MovieBookingSystem.PaymentStragegyPattern.PaymentService;
import Projects.MovieBookingSystem.Service.BookingService;
import Projects.MovieBookingSystem.UtilityPackage.Booking;
import Projects.MovieBookingSystem.UtilityPackage.User;

public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processPayment(String bookingId, User user, double amount) throws Exception {
        paymentService.processPayment(bookingId, user, amount);
    }
}
