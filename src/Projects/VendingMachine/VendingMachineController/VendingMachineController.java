package Projects.VendingMachine.VendingMachineController;

import Projects.VendingMachine.CommonEnums.Coin;
import Projects.VendingMachine.PaymentStrategyPattern.PaymentProcessor;
import Projects.VendingMachine.Utility.Inventory;
import Projects.VendingMachine.Utility.Item;
import Projects.VendingMachine.Utility.ItemShelf;
import Projects.VendingMachine.VendingMachineStatePattern.ConcreteStatePattern.HasMoneyState;
import Projects.VendingMachine.VendingMachineStatePattern.ConcreteStatePattern.IdleState;
import Projects.VendingMachine.VendingMachineStatePattern.ConcreteStatePattern.SelectionState;
import Projects.VendingMachine.VendingMachineStatePattern.VendingMachineContext;
import Projects.VendingMachine.VendingMachineStatePattern.VendingMachineState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineController {
    private static VendingMachineController instance;
    Inventory inventory;
    VendingMachineContext vendingMachineContext;
    PaymentProcessor paymentProcessor;
    List<Coin> coinsList;
    int selectedItemCode;

    private VendingMachineController(int numberOfShelf) {
        this.inventory = new Inventory(numberOfShelf);
        this.vendingMachineContext = new VendingMachineContext();
        this.paymentProcessor = new PaymentProcessor();
        this.coinsList = new ArrayList<>();
    }

    public static VendingMachineController getInstance(int numberOfShelf) {
        if (instance == null) {
            instance = new VendingMachineController(numberOfShelf);
        }
        return instance;
    }

    public void clickOnInsertCoinButton(Coin coin) {
        VendingMachineState currentState = vendingMachineContext.getCurrentState();
        if (currentState instanceof IdleState || currentState instanceof HasMoneyState) {
            System.out.println("Inserted " + coin.name() + " worth " + coin.value);
            coinsList.add(coin);
            vendingMachineContext.advanceNext();
            System.out.println("Current State : " + vendingMachineContext.getCurrentState().getStateName());
        } else {
            System.out.println("Cannot insert coin in " + currentState.getStateName());
        }
    }

    public void clickOnStartProductSelectionButton(int codeNumber) {
        VendingMachineState currentState = vendingMachineContext.getCurrentState();
        if (currentState instanceof HasMoneyState) {
            vendingMachineContext.advanceNext();
            selectProduct(codeNumber);
            System.out.println("Current State : " + vendingMachineContext.getCurrentState().getStateName());

        } else {
            System.out.println("Product selection button can only be clicked in HasMoney state");
        }
    }

    public void selectProduct(int codeNumber) {
        VendingMachineState currentState = vendingMachineContext.getCurrentState();
        if (currentState instanceof SelectionState) {
            try {
                Item item = inventory.getItem(codeNumber);

                int balance = getBalance();

//                if(balance < item.getPrice()) {
//                    System.out.println("Insufficient amount. Product price: " + item.getPrice() + ", paid "+ balance);
//                    return;
//                }

                setSelectedItemCode(codeNumber);
                dispenseItem(codeNumber);
                vendingMachineContext.advanceNext();
                if (balance >= item.getPrice()) {
                    double change = balance - item.getPrice();
                    System.out.println("Return change: " + change);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Products can only be selected in Selection state");
        }
    }

    public void dispenseItem(int codeNumber) {
        VendingMachineState currentState = vendingMachineContext.getCurrentState();
        if (currentState instanceof SelectionState) {
            Item item = inventory.getItem(codeNumber);
            System.out.println("Dispensing: " + item.getType());
            inventory.updateSoldOutItem(codeNumber);

            resetBalance();
            resetSelection();
            vendingMachineContext.advanceNext();
            System.out.println("Current State : " + vendingMachineContext.getCurrentState().getStateName());
        } else {
            System.out.println("System cannot dispense in : " + currentState);
        }
    }

    public void updateInventory(Item item, int codeNumber) {
        VendingMachineState currentState = vendingMachineContext.getCurrentState();
        if(currentState instanceof IdleState) {
            inventory.addItem(item, codeNumber);
            System.out.println("Added " + item.getType() + " to slot " + codeNumber);
        } else {
            System.out.println("Inventory can only be updated in Idle state");
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinsList() {
        return coinsList;
    }

    public void setCoinsList(List<Coin> coinsList) {
        this.coinsList = coinsList;
    }

    public int getSelectedItemCode() {
        return selectedItemCode;
    }

    public void setSelectedItemCode(int codeNumber) {
        this.selectedItemCode = codeNumber;
    }

    public void resetSelection() {
        this.selectedItemCode = 0;
    }

    public int getBalance() {
        int balance = 0;

        for (Coin coin: coinsList) {
            balance += coin.value;
        }

        return balance;
    }

    public void resetBalance() {
        coinsList.clear();
    }
}