package Projects.MovieBookingSystem.UtilityPackage;

import Projects.MovieBookingSystem.CommonEnums.BookingStatus;

import java.util.List;

public class Booking {
    String id;
    BookingStatus bookingStatus;
    User user;
    Show show;
    List<Seat> seatsBooked;

    public Booking(String id, Show show, User user, List<Seat> seatsBooked) {
        this.id = id;
        this.user = user;
        this.seatsBooked = seatsBooked;
        this.show = show;
    }

    public boolean isConfirmed() {
        return bookingStatus == BookingStatus.CONFIRMED;
    }

    public String getId() {
        return id;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeatsBooked() {
        return seatsBooked;
    }

    public void confirmBooking() {
        bookingStatus = BookingStatus.CONFIRMED;
    }

    public void expireBooking() {
        bookingStatus = BookingStatus.EXPIRED;
    }
}
