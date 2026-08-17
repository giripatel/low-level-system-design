package Projects.ParkingLot.PaymentStrategy.ConcreteStrategies;

import Projects.ParkingLot.PaymentStrategy.PaymentStrategy;

public class UPI implements PaymentStrategy {

    public UPI(double amount) {

    }

    /**
     * @param amount
     */
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment successful using UPI: " + amount);
    }
}
