package Projects.MovieBookingSystem.Service;

import Projects.MovieBookingSystem.CommonEnums.SeatCategory;
import Projects.MovieBookingSystem.UtilityPackage.Screen;
import Projects.MovieBookingSystem.UtilityPackage.Seat;
import Projects.MovieBookingSystem.UtilityPackage.Theatre;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TheatreService {

    Map<Integer, Theatre> theatres;
    Map<Integer, Screen> screens;
    Map<Integer, Seat> seats;

    private AtomicInteger theatreCounter;
    private AtomicInteger screenCounter;
    private AtomicInteger seatCounter;

    public TheatreService() {
        this.theatres = new HashMap<>();
        this.screens = new HashMap<>();
        this.seats = new HashMap<>();
        this.theatreCounter = new AtomicInteger(0);
        this.screenCounter = new AtomicInteger(0);
        this.seatCounter = new AtomicInteger(0);
    }

    public Theatre getTheatre(int id) throws Exception{
        if (!theatres.containsKey(id)) {
            throw new Exception("theatre with ID " + id +" not found.");
        }
        return theatres.get(id);
    }

    public Screen getScreen(int id) throws Exception {
        if (!screens.containsKey(id)) {
            throw new Exception("theatre with ID " + id +" not found.");
        }
        return screens.get(id);
    }

    public Seat getSeat(Integer id) throws Exception {
        if (!seats.containsKey(id)) {
            throw new Exception("theatre with ID " + id +" not found.");
        }
        return seats.get(id);
    }

    public Theatre createtheatre(String theatreName) {
        int theatreId = theatreCounter.incrementAndGet();
        Theatre theatre = new Theatre(theatreId, theatreName);
        theatres.put(theatreId, theatre);
        return theatre;
    }

    public Screen createScreenInTheatre(String screenName, Theatre theatre) {
        int screenId = screenCounter.incrementAndGet();
        Screen screen = new Screen(screenId, screenName, theatre);
        theatre.addScreen(screen);
        screens.put(screenId, screen);
        return screen;
    }

    public Seat createSeatInScreen(Integer row, SeatCategory seatCategory, Screen screen) {
        int seatId = seatCounter.incrementAndGet();
        Seat seat = new Seat(seatId, row, seatCategory);
        screen.addSeat(seat);
        seats.put(seatId, seat);
        return seat;
    }
}
