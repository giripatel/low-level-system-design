package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Strategy.Solution;

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.setPaymentStrategy(new UPIPayment());
        paymentService.pay();
    }
}
