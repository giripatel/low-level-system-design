package Projects.ATM_Machine.ATMStatePattern;

import Projects.ATM_Machine.ATMStatePattern.ConcreteStateClasses.HasCardState;
import Projects.ATM_Machine.ATMStatePattern.ConcreteStateClasses.IdleState;
import Projects.ATM_Machine.ATMStatePattern.ConcreteStateClasses.SelectOperationState;
import Projects.ATM_Machine.ATMStatePattern.ConcreteStateClasses.TransactionState;
import Projects.ATM_Machine.CommonEnums.CashType;
import Projects.ATM_Machine.CommonEnums.TransactionType;
import Projects.ATM_Machine.UtilityClasses.ATMInventory;
import Projects.ATM_Machine.UtilityClasses.Account;
import Projects.ATM_Machine.UtilityClasses.Card;

import javax.crypto.spec.PSource;
import java.util.HashMap;
import java.util.Map;

public class ATMMachineContext {

    ATMStateFactory atmStateFactory;
    Account currentAccount;
    Card currentCard;
    ATMState currentState;
    ATMInventory atmInventory;
    Map<String, Account> accounts;
    TransactionType currentTransactionType;

    public ATMMachineContext() {
        this.atmStateFactory = ATMStateFactory.getInstance();
        this.currentState = atmStateFactory.createIdleState();
        this.atmInventory = new ATMInventory();
        this.accounts = new HashMap<>();
        System.out.println("ATM Initialized in " + currentState.getStateName());
    }

    public void advanceState() {
        ATMState nextState = currentState.nextState(this);
        this.currentState = nextState;
//        System.out.println("ATM is in " + nextState.getStateName());
    }

    public void insertCard(Card card) {
        if (currentState instanceof IdleState) {
            this.currentCard = card;
            advanceState();
            System.out.println("Card inserted ");
        } else {
            System.out.println("ATM is not idle state");
        }
    }

    public void enterPin(int pin) {
        if (currentState instanceof HasCardState) {
            if (currentCard.validatePin(pin)) {
                this.currentAccount = accounts.get(currentCard.getAccountNumber());
                advanceState();
            } else {
                System.out.println("Incorrect pin, please try again");
            }
        } else {
            System.out.println("ATM doesn't have a card inserted");
        }
    }

    public void selectOperation(TransactionType transactionType) {
        if (currentState instanceof SelectOperationState) {
            currentTransactionType = transactionType;
            advanceState();
        }
    }

    public void performTransaction(int amount) {
        if (currentState instanceof TransactionState) {
            try {
                if (currentTransactionType == TransactionType.WITHDRAW_CASH) {
                    performWithdrawal(amount);
                } else if (currentTransactionType == TransactionType.CHECK_BALANCE) {
                    checkBalance();
                }
                advanceState();
            } catch (Exception e) {
                System.out.println("Transaction failed : " + e.getMessage());
                currentState = getStateFactory().createSelectOperationState();
            }
        }
    }

    public void cancelTransaction() {
        if (currentState instanceof TransactionState) {
            returnCard();
        }
    }
    public void returnCard() {
        if (currentState instanceof HasCardState || currentState instanceof SelectOperationState
                || currentState instanceof TransactionState) {
            System.out.println("Card returned to user");
            restATM();
        } else {
            System.out.println("ATM doesn't have card");
        }
    }

    public void restATM() {
        this.currentState = getStateFactory().createIdleState();
        this.currentAccount = null;
        this.currentCard = null;
        this.currentTransactionType = null;
    }

    public void performWithdrawal(int amount) throws Exception{
        if (!currentAccount.withdraw(amount)) {
            throw new Exception("Insufficient balance");
        }

        if (!atmInventory.hasSufficientBalance(amount)) {
            currentAccount.deposit(amount);
            throw new Exception("Insufficient cash in ATM");
        }

        Map<CashType, Integer> dispensedCash = atmInventory.dispenseCash(amount);
        if (dispensedCash == null) {
            currentAccount.deposit(amount);
            throw new Exception("Unable to dispense cash");
        }

        for (Map.Entry<CashType, Integer> entry: dispensedCash.entrySet()) {
            System.out.println(entry.getValue() + " - $" + entry.getKey());
        }
    }

    public void checkBalance() {
        System.out.println("Your balance is :$ " + currentAccount.getBalance());
    }
    public Card getCurrentCard() {
        return currentCard;
    }

    public ATMStateFactory getStateFactory() {
        return atmStateFactory;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public TransactionType getCurrentSelectedOperation() {
        return currentTransactionType;
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
