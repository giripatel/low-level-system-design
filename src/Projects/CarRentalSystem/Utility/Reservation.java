package Projects.CarRentalSystem.Utility;

import Projects.CarRentalSystem.CommonEnums.ReservationStatus;
import Projects.CarRentalSystem.VehicleFactoryPattern.Vehicle;

import java.util.Date;

public class Reservation {
    int id;
    User user;
    Vehicle vehicle;
    RentalStore pickupStore;
    RentalStore returnStore;
    Date startDate;
    Date endDate;
    ReservationStatus reservationStatus;
    double totalAmount;

    public Reservation(int id, User user, Vehicle vehicle, RentalStore pickupStore, RentalStore returnStore, Date startDate, Date endDate) {
        this.id = id;
        this.user = user;
        this.vehicle = vehicle;
        this.pickupStore = pickupStore;
        this.returnStore = returnStore;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reservationStatus = ReservationStatus.IN_PROGRESS;
    }

    public void confirmReservation() {

    }

    public void startRental() {

    }

    public void completeRental() {
        this.reservationStatus = ReservationStatus.COMPLETED;
    }

    public void cancelReservation() {
        this.reservationStatus = ReservationStatus.CANCELLED;
    }

    public int getId() {
        return id;
    }

    public double getTotalAmount() {
        return vehicle.calculateRentalFare(2);
    }
}
