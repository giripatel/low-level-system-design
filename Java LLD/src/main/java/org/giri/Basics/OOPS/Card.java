package main.java.org.giri.Basics.OOPS;

public abstract class Card implements PaymentMethod {
    private String cardNumber;
    private String userName;

    public Card(String id, String name) {
        this.cardNumber = id;
        this.userName = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getUserName() {
        return  userName;
    }
}
