package Projects.MovieBookingSystem.Interfaces;

import Projects.MovieBookingSystem.UtilityPackage.Seat;
import Projects.MovieBookingSystem.UtilityPackage.Show;
import Projects.MovieBookingSystem.UtilityPackage.User;

import java.util.List;

public interface ISeatLockProvider {
    void lockSeats(Show show, List<Seat> seats, User user) throws Exception;
    void unLockSeats(Show show, List<Seat> seats, User user);
    boolean validateLock(Show show, Seat seat, User user);
    List<Seat> getLockedSeats(Show show);
}
