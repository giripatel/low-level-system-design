package Projects.VendingMachine.PaymentStrategyPattern.ConcretePaymentStrategies;

import Projects.VendingMachine.PaymentStrategyPattern.PaymentStrategy;

public class CashPaymentStrategy implements PaymentStrategy {

    public CashPaymentStrategy(double amount) {

    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid using Cash  Amount : " + amount);
    }
}
