package Projects.ParkingLot.PaymentStrategy.ConcreteStrategies;

import Projects.ParkingLot.PaymentStrategy.PaymentStrategy;

public class CreditCard implements PaymentStrategy {

    public CreditCard(double amount) {

    }
    /**
     * @param amount
     */
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment successful using Credit Card: " + amount);
    }
}
