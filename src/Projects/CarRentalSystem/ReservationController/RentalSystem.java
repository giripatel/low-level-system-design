package Projects.CarRentalSystem.ReservationController;

import Projects.CarRentalSystem.PaymentStrategyPattern.PaymentProcessor;
import Projects.CarRentalSystem.PaymentStrategyPattern.PaymentStrategy;
import Projects.CarRentalSystem.Utility.RentalManager;
import Projects.CarRentalSystem.Utility.RentalStore;
import Projects.CarRentalSystem.Utility.Reservation;
import Projects.CarRentalSystem.Utility.User;
import Projects.CarRentalSystem.VehicleFactoryPattern.Vehicle;

import java.util.*;

public class RentalSystem {
    static RentalSystem instance;
    PaymentProcessor paymentProcessor;
    List<RentalStore> rentalStoreList;
    RentalManager rentalManager;
    Map<Integer, User> userMap;
    int nextUserId;

    public RentalSystem() {
        this.rentalStoreList = new ArrayList<>();
        this.rentalManager = new RentalManager();
        this.paymentProcessor = new PaymentProcessor();
        this.userMap = new HashMap<>();
        this.nextUserId = 0;
    }

    public void registerUser(User user) {
        int id = user.getId();
        if (!userMap.containsKey(id)) {
            userMap.put(id, user);
        }
    }

    public boolean processPayment(double amount, PaymentStrategy paymentStrategy) {
        paymentProcessor.processPayment(amount, paymentStrategy);
        return true;
    }

    public static RentalSystem getInstance() {
        if (instance == null) {
            instance = new RentalSystem();
        }
        return instance;
    }

    public List<RentalStore> getRentalStoreList() {
        return rentalStoreList;
    }

    public RentalManager getRentalManager() {
        return rentalManager;
    }

    public List<User> getUserMap() {
        return (List<User>) userMap.values();
    }

    public int getNextUserId() {
        return nextUserId;
    }

    public Reservation createReservation(User user, Vehicle vehicle, RentalStore pickupStore, RentalStore returnStore, Date startDate, Date endDate) {
        return rentalManager.createReservation(user, vehicle, pickupStore, returnStore, startDate, endDate);
    }

    public void startRental(int id) {
        rentalManager.getReservation(id).startRental();
    }

    public void cancelReservation(Reservation reservation) {
        reservation.cancelReservation();
    }

    public void addStore(RentalStore rentalStore) {
        rentalStoreList.add(rentalStore);
    }

    public User getUserId(int id) {
        return userMap.get(id);
    }

    public void completeRental(int id) {
        rentalManager.completeRental(id);
    }
}
