package main.java.org.giri.Basics.OOPS;

public class Wallet implements PaymentMethod {
    String userId;

    public Wallet(String userid){
        this.userId = userid;
    }

    @Override
    public void pay() {
        System.out.println("Paying from Wallet " + userId);
    }
}
