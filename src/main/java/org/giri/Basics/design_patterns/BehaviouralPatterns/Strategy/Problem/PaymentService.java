package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Strategy.Problem;

public class PaymentService {
    public void processPayment(String paymentMethod) {
        if(paymentMethod.equals("Credit Card")) {
            System.out.println("Processing payment via : " + paymentMethod);
        }
        else if (paymentMethod.equals("Debit Card")) {
            System.out.println("Processing payment via : " + paymentMethod);
        }
        else if (paymentMethod.equals("UPI")) {
            System.out.println("Processing payment via : " + paymentMethod);
        }
        else {
            System.out.println("Unsupported payment method");
        }
    }
}
