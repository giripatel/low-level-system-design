package Projects.MovieBookingSystem.PaymentStragegyPattern.ConcretePaymentStrategies;

import Projects.MovieBookingSystem.PaymentStragegyPattern.PaymentStrategy;

public class UPIStrategy implements PaymentStrategy {
    /**
     * @param amount
     * @return
     */
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Paid using UPI: "  + amount);
        return true;
    }
}
