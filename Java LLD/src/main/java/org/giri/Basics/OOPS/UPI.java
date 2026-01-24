package main.java.org.giri.Basics.OOPS;

public class UPI implements PaymentMethod {
    String userId;

    public UPI(String userId) {
        this.userId = userId;
    }

    public void pay() {
        System.out.println("Pyaing from UPI : " + userId);
    }
}
