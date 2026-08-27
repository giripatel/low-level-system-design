package Projects.VendingMachine.InventoryObserverPattern;

public class ItemObserver implements Observer{
    @Override
    public void notifyInventory(int quantity) {
        System.out.println("Quantity remaining : " + quantity);
    }
}
