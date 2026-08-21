package Projects.CarRentalSystem.PaymentStrategyPattern.ConcreteClasses;

import Projects.CarRentalSystem.PaymentStrategyPattern.PaymentStrategy;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    String cardNumber;
    String name;
    String expiryDate;

    @Override
    public void processPayment(double amount) {
        System.out.println("Payed with Credit card: " + amount);
    }
}
