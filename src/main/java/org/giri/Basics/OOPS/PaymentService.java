package main.java.org.giri.Basics.OOPS;

import java.util.HashMap;

public class PaymentService {
    HashMap<String, PaymentMethod> paymentMethodHashMap;

    public PaymentService() {
        this.paymentMethodHashMap = new HashMap<>();
    }

    public void addPaymentMethod(String name, PaymentMethod paymentMethod) {
        paymentMethodHashMap.put(name, paymentMethod);
    }

    public void makePayment(String name) {
        PaymentMethod paymentMethod = paymentMethodHashMap.get(name);
        paymentMethod.pay();
    }
}
