package Projects.MovieBookingSystem;

import Projects.MovieBookingSystem.CommonEnums.SeatCategory;
import Projects.MovieBookingSystem.ConcreteLockProviders.SeatLockProvider;
import Projects.MovieBookingSystem.Controller.*;
import Projects.MovieBookingSystem.Interfaces.ISeatLockProvider;
import Projects.MovieBookingSystem.PaymentStragegyPattern.ConcretePaymentStrategies.UPIStrategy;
import Projects.MovieBookingSystem.PaymentStragegyPattern.PaymentService;
import Projects.MovieBookingSystem.PaymentStragegyPattern.PaymentStrategy;
import Projects.MovieBookingSystem.Service.*;
import Projects.MovieBookingSystem.UtilityPackage.Movie;
import Projects.MovieBookingSystem.UtilityPackage.User;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        try {

            // Lock Provider
            ISeatLockProvider seatLockProvider = new SeatLockProvider(200);

            // User
            User user1 = new User("example1.com", "1");
            User user2 = new User("example2.com", "2");

            // Payment Strategy
            PaymentStrategy paymentStrategy = new UPIStrategy();

            MovieService movieService = new MovieService();
            TheatreService theatreService = new TheatreService();
            ShowService showService = new ShowService();
            BookingService bookingService = new BookingService(seatLockProvider);
            SeatAvailabilityService seatAvailabilityService = new SeatAvailabilityService(bookingService, seatLockProvider);
            PaymentService paymentService = new PaymentService(paymentStrategy, bookingService);

            MovieController movieController = new MovieController(movieService);
            TheatreController theatreController = new TheatreController(theatreService);
            ShowController showController = new ShowController(seatAvailabilityService, showService, theatreService, movieService);
            BookingController bookingController = new BookingController(showService, bookingService, theatreService);
            PaymentController paymentController = new PaymentController(paymentService);

            System.out.println("Create Theatre");
            int theatreId = theatreController.createTheatre("PVR Cinemas");
            System.out.println("Created Theatre with id " + theatreId);

            System.out.println("Create Screen");
            int screenId = theatreController.createScreenInTheatre("Hall 3", theatreId);
            System.out.println("Create Screen " + screenId);

            System.out.println("Create Seat");
            int seatId1 = theatreController.createSeatInScreen(1, SeatCategory.SILVER, screenId);
            System.out.println("Create Seat " + seatId1);

            System.out.println("Create Seat");
            int seatId2 = theatreController.createSeatInScreen(1, SeatCategory.SILVER, screenId);
            System.out.println("Create Seat " + seatId2);

            System.out.println("Create Seat");
            int seatId3 = theatreController.createSeatInScreen(1, SeatCategory.SILVER, screenId);
            System.out.println("Create Seat " + seatId3);

            System.out.println("Create Seat");
            int seatId4 = theatreController.createSeatInScreen(1, SeatCategory.SILVER, screenId);
            System.out.println("Create Seat " + seatId4);

            System.out.println("Create Movie");
            int movieId = movieController.createMove("X Man", 90);
            System.out.println("Create Movie " + movieId);

            System.out.println("Create Show");
            int showId1 = showController.createShow(movieId, screenId, new Date(), 90);
            System.out.println("Create Show " + showId1);

            System.out.println("Create Show");
            int showId2 = showController.createShow(movieId, screenId, new Date(2026, 9, 20), 90);
            System.out.println("Create Show " + showId2);

            System.out.println("================================================");
            Thread t1 = new Thread(() -> {
                try {
                    System.out.println("Thread : " + Thread.currentThread().getName());
                    String bookingId1 = bookingController.createBooking(showId1,user1, Arrays.asList(seatId1, seatId2));
                    paymentController.processPayment(bookingId1, user1, 200);
                } catch (Exception e) {
                    throw new RuntimeException(e);
//                    System.out.println("Thread : " + Thread.currentThread().getName());
//                    System.out.println("Exception e " + e.getMessage());
                }
            });
            Thread t2 = new Thread(() -> {
                try {
                    System.out.println("Thread : " + Thread.currentThread().getName());
                    String bookingId2 = bookingController.createBooking(showId2,user2, Arrays.asList(seatId3, seatId2));
                    paymentController.processPayment(bookingId2, user2, 200);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }

    }
}
