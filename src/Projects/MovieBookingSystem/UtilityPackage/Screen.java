package Projects.MovieBookingSystem.UtilityPackage;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    int id;
    String name;
    List<Seat> seatList;
    Theatre theater;

    public Screen(int id, String name,Theatre theatre) {
        this.id = id;
        this.name = name;
        this.theater = theatre;
        this.seatList = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        seatList.add(seat);
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public Theatre getTheater() {
        return theater;
    }
}
