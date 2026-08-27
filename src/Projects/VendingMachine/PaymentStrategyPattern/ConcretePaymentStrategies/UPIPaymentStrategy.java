package Projects.VendingMachine.PaymentStrategyPattern.ConcretePaymentStrategies;

import Projects.VendingMachine.PaymentStrategyPattern.PaymentStrategy;

public class UPIPaymentStrategy implements PaymentStrategy {
    public UPIPaymentStrategy(double amount) {

    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid using UPI Amount : " + amount);
    }
}
