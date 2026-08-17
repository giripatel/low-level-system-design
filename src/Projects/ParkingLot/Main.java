package Projects.ParkingLot;

import Projects.ParkingLot.ParkingController.ParkingLot;
import Projects.ParkingLot.ParkingFeeStrategy.ConcreateStrategies.BasicHourRateStrategy;
import Projects.ParkingLot.ParkingFeeStrategy.ConcreateStrategies.PremiumRateStrategy;
import Projects.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import Projects.ParkingLot.ParkingSpots.ConcretePakringSpots.BikeParkingSpot;
import Projects.ParkingLot.ParkingSpots.ConcretePakringSpots.CarParkingSpot;
import Projects.ParkingLot.ParkingSpots.ParkingSpot;
import Projects.ParkingLot.PaymentStrategy.ConcreteStrategies.CreditCard;
import Projects.ParkingLot.PaymentStrategy.ConcreteStrategies.UPI;
import Projects.ParkingLot.PaymentStrategy.PaymentStrategy;
import Projects.ParkingLot.Utility.DurationType;
import Projects.ParkingLot.VehicleFactoryPattern.Vehicle;
import Projects.ParkingLot.VehicleFactoryPattern.VehicleFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ParkingFeeStrategy parkingFeeStrategy1 = new BasicHourRateStrategy();
        ParkingFeeStrategy parkingFeeStrategy2 = new PremiumRateStrategy();

        Vehicle v1 = VehicleFactory.createVehicle("bike", "l1", parkingFeeStrategy1);
        Vehicle v2 = VehicleFactory.createVehicle("car", "l2", parkingFeeStrategy1);

        ParkingSpot p1 = new BikeParkingSpot(1, "bike");
        ParkingSpot p2 = new CarParkingSpot(2, "car");

        List<ParkingSpot> spots = new ArrayList<>();
        spots.add(p1);
        spots.add(p2);

        ParkingLot parkingLot = new ParkingLot(spots);
        ParkingSpot pV1 = parkingLot.parkVehicle(v1);
        ParkingSpot pV2 = parkingLot.parkVehicle(v2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose from the below payment methods");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        int paymentMethod = scanner.nextInt();

        if (pV1 != null) {
            Vehicle vehicle1 = pV1.getVehicle();
            double fare = vehicle1.calculateFee(2, DurationType.HOURS);
            PaymentStrategy paymentStrategy3 = getPaymentStrategy(paymentMethod, fare);
            paymentStrategy3.processPayment(fare);
            parkingLot.vacateVehicle(pV1, v1);
        }
    }

    private static PaymentStrategy getPaymentStrategy(int type, double amount) {
        switch (type) {
            case 1: return new  UPI(amount);
            case 2: return new CreditCard(amount);
            default: throw new IllegalArgumentException("Invalid payment method");
        }
    }
}
