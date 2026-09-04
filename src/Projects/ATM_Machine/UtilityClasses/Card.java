package Projects.ATM_Machine.UtilityClasses;

public class Card {
    private String id;
    private int pin;
    private String accountNumber;

    public Card(String id, int pin, String accountNumber) {
        this.id = id;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }

    public String getId() {
        return id;
    }

    public int getPin() {
        return this.pin;
    }
    public boolean validatePin(int pin) {
        return this.pin == pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
