package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Strategy.Solution;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void processPayment() {
        System.out.println("Processing payment via Credit Card");
    }
}
