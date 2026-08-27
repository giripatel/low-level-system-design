package Projects.VendingMachine.Utility;

import Projects.VendingMachine.InventoryObserverPattern.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    List<Observer> observers;
    ItemShelf[] inventory;

    public Inventory(int numberOfShelf) {
        this.observers = new ArrayList<>();
        this.inventory = new ItemShelf[numberOfShelf];
        initializeInventory(numberOfShelf);
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] itemShelves) {
        this.inventory = itemShelves;
    }

    public void initializeInventory(int numberOfShelf) {
        int startCode = 100;
        for (int i = 0; i < numberOfShelf; i ++) {
            inventory[i] = new ItemShelf(startCode);
            startCode ++;
        }
    }

    public void addItem(Item item, int codeNumber) {
        for (ItemShelf itemShelf: inventory) {
            if (itemShelf.getCode() == codeNumber) {
                itemShelf.addItem(item);
            }
        }
    }

    public void updateSoldOutItem(int codeNumber) {
        for (ItemShelf itemShelf: inventory) {
            if (itemShelf.getCode() == codeNumber) {
                if (itemShelf.getItems().isEmpty()) {
                    itemShelf.setSoldOut(true);
                }
            }
        }
    }

    public void removeItem(int codeNumber) {
        for (ItemShelf itemShelf: inventory) {
            if (itemShelf.getCode() == codeNumber) {
                itemShelf.removeItem(itemShelf.getItems().get(0));
            }
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public Item getItem(int code) {
        for(ItemShelf shelf: inventory) {
            if(shelf.getCode() == code) {
                return shelf.getItem();
            }
        }
        return null;
    }

//    public List<Item> getItems() {
//
//    }
//
//    public void purchaseItem(int itemId, int quantity) {
//        if (!itemMap.containsKey(itemId)) {
//            System.out.println("Item not available");
//            return;
//        }
//
//        Item purchasingItem = itemMap.get(itemId);
//        if (purchasingItem.getQuantity() < quantity) {
//            System.out.println("Quantity is less than purchasing");
//            return;
//        }
//
//        purchasingItem.removeQuantity(quantity);
//        if (purchasingItem.getQuantity() < purchasingItem.threshold) {
//            notifyObservers(purchasingItem.getQuantity());
//        }
//    }
//
//    public void addQuantity(int itemId, int quantity) {
//        if (!itemMap.containsKey(itemId)) {
//            System.out.println("Item is not in inventory");
//        }
//        itemMap.get(itemId).addQuantity(quantity);
//    }
//
//    public void removeItemQuantity(int itemId, int quantity) {
//        if (!itemMap.containsKey(itemId)) {
//            System.out.println("Item not in inventory");
//        }
//        itemMap.get(itemId).removeQuantity(quantity);
//    }
//
//    public void addObserver(Observer observer) {
//        observers.add(observer);
//    }
//
//    public void removeObserver(Observer observer) {
//        observers.remove(observer);
//    }
//
//    public void notifyObservers(int quantity) {
//        for (Observer observer : observers) {
//            observer.notifyInventory(quantity);
//        }
//    }
}
