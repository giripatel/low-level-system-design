package Projects.ATM_Machine;

import Projects.ATM_Machine.ATMStatePattern.ATMMachineContext;
import Projects.ATM_Machine.CommonEnums.TransactionType;
import Projects.ATM_Machine.UtilityClasses.Account;
import Projects.ATM_Machine.UtilityClasses.Card;

public class Main {
    public static void main(String[] args) {

        Account account = new Account("a1", 1000);
        Card card = new Card("c1", 123, account.getAccountNumber());

        ATMMachineContext atmMachineContext = new ATMMachineContext();
        atmMachineContext.addAccount(account);

        atmMachineContext.insertCard(card);
        atmMachineContext.enterPin(123);
        atmMachineContext.selectOperation(TransactionType.CHECK_BALANCE);
        atmMachineContext.performTransaction(0);

        atmMachineContext.selectOperation(TransactionType.WITHDRAW_CASH);
        atmMachineContext.performTransaction(100);

        atmMachineContext.selectOperation(TransactionType.CHECK_BALANCE);
        atmMachineContext.performTransaction(0);

    }
}
