package Projects.MovieBookingSystem.PaymentStragegyPattern;

public class PaymentHandler {
    PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy paymentStrategy) {
        this.strategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        strategy.processPayment(amount);
    }
}
