package main.java.org.giri.Basics.OOPS;

public class DebiCard extends Card {
    public DebiCard(String cardNumber, String userName) {
        super(cardNumber, userName);
    }

    public void pay() {
        System.out.println("Paying from DebitCard ........");
    }
}
