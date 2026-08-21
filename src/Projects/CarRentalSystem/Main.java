package Projects.CarRentalSystem;

import Projects.CarRentalSystem.CommonEnums.VehicleState;
import Projects.CarRentalSystem.CommonEnums.VehicleType;
import Projects.CarRentalSystem.PaymentStrategyPattern.ConcreteClasses.UPIPaymentStrategy;
import Projects.CarRentalSystem.PaymentStrategyPattern.PaymentStrategy;
import Projects.CarRentalSystem.ReservationController.RentalSystem;
import Projects.CarRentalSystem.Utility.Location;
import Projects.CarRentalSystem.Utility.RentalStore;
import Projects.CarRentalSystem.Utility.Reservation;
import Projects.CarRentalSystem.Utility.User;
import Projects.CarRentalSystem.VehicleFactoryPattern.Vehicle;
import Projects.CarRentalSystem.VehicleFactoryPattern.VehicleFactory;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RentalSystem rentalSystem = RentalSystem.getInstance();

        User user1 = new User(1, "U1");
        User user2 = new User(2, "U2");
        rentalSystem.registerUser(user1);
        rentalSystem.registerUser(user2);

        Location l1 = new Location("l1", "Hyd", "S1", "51");
        Location l2 = new Location("l2", "MI", "S2", "41");

        RentalStore rentalStore1 = new RentalStore(1, "R1", l1);
        RentalStore rentalStore2 = new RentalStore(2, "R2", l2);
        rentalSystem.addStore(rentalStore1);
        rentalSystem.addStore(rentalStore2);

        Vehicle v1 = VehicleFactory.createVehicle("reg1", "M1", VehicleType.SUV, VehicleState.AVAILABLE);
        Vehicle v2 = VehicleFactory.createVehicle("reg2", "M2", VehicleType.LUXURY, VehicleState.AVAILABLE);
        rentalStore1.addVehicle("reg1", v1);
        rentalStore1.addVehicle("reg2", v2);

        PaymentStrategy paymentStrategy1 = new UPIPaymentStrategy();

        List<Vehicle> availableVehicles = rentalStore1.getAvailableVehicles();
        for (Vehicle vehicle: availableVehicles) {
            System.out.println("Available " + vehicle.getVehicleType());
        }

        Reservation reservation1 = rentalSystem.createReservation(user1, v1, rentalStore1, rentalStore2, new Date(2026, 4, 01), new Date(2026, 4, 01));

        Scanner scanner = new Scanner(System.in);
        System.out.println("nProcessing payment for reservation #" + reservation1.getId());
        System.out.println("Total amount: $" + reservation1.getTotalAmount());
        System.out.println("Select payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");
        System.out.println("3. PayPal");

        boolean paymentStatus = rentalSystem.processPayment(50.0, paymentStrategy1);

        if (paymentStatus) {
            System.out.println("Payment Successful");
            rentalSystem.startRental(reservation1.getId());
            System.out.println("Simulating rental period");
            rentalSystem.completeRental(reservation1.getId());
        }

    }
}
