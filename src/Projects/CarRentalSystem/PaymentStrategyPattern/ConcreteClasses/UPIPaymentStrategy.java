package Projects.CarRentalSystem.PaymentStrategyPattern.ConcreteClasses;

import Projects.CarRentalSystem.PaymentStrategyPattern.PaymentStrategy;

public class UPIPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Payed with Credit card: " + amount);
    }
}
