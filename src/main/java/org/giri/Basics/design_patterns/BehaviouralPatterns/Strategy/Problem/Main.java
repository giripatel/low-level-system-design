package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Strategy.Problem;

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.processPayment("Credit Card");
        paymentService.processPayment("Debit Card");

        // Problem -> for adding new payment method we need to modify the existing code
        // it violates the Open / Closed Principle
        paymentService.processPayment("Paypal");
    }
}
