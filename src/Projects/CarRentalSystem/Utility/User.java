package Projects.CarRentalSystem.Utility;

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String name;
    List<Reservation> reservations;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public void deleteReservation(Reservation reservation) {
        this.reservations.remove(reservation);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
