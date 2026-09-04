package Projects.ATM_Machine.UtilityClasses;

public class Account {
    String accountNumber;
    int balance;

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public boolean hasSufficientBalance(int amount) {
        if (amount <= balance) {
            return true;
        }
        return false;
    }

    public boolean withdraw(int amount) {
        if (!hasSufficientBalance(amount)) return false;
        balance -= amount;
        return true;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
