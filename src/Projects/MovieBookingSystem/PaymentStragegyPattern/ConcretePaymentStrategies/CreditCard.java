package Projects.MovieBookingSystem.PaymentStragegyPattern.ConcretePaymentStrategies;

import Projects.MovieBookingSystem.PaymentStragegyPattern.PaymentStrategy;

public class CreditCard implements PaymentStrategy {
    /**
     * @param amount
     * @return
     */
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Credit Card payment " + amount);
        return true;
    }
}
