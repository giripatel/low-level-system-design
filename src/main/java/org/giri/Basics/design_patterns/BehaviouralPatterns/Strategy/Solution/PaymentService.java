package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Strategy.Solution;

public class PaymentService {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay() {
        strategy.processPayment();
    }
}
