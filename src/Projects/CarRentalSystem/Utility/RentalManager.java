package Projects.CarRentalSystem.Utility;

import Projects.CarRentalSystem.VehicleFactoryPattern.Vehicle;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RentalManager {

    Map<Integer, Reservation> reservationMap;
    int nextReservationId;

    public RentalManager() {
        this.reservationMap = new HashMap<>();
        this.nextReservationId = 0;
    }

    public Reservation createReservation(User user, Vehicle vehicle, RentalStore pickupStore, RentalStore returnStore, Date startDate, Date endDate) {
        Reservation reservation = new Reservation( ++ nextReservationId, user, vehicle, pickupStore, returnStore, startDate, endDate);
        reservationMap.put(nextReservationId, reservation);

        return reservation;
    }

    public void confirmReservation(int id) {
        reservationMap.get(id).confirmReservation();
    }

    public void completeRental(int id) {
        reservationMap.get(id).completeRental();
    }

    public void cancelReservation(int id) {
        reservationMap.get(id).cancelReservation();
    }

    public Reservation getReservation(int id) {
        return reservationMap.get(id);
    }
}
