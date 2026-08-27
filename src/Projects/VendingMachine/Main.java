package Projects.VendingMachine;

import Projects.VendingMachine.CommonEnums.Coin;
import Projects.VendingMachine.CommonEnums.ItemType;
import Projects.VendingMachine.Utility.Inventory;
import Projects.VendingMachine.Utility.Item;
import Projects.VendingMachine.Utility.ItemShelf;
import Projects.VendingMachine.VendingMachineController.VendingMachineController;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        VendingMachineController controller = VendingMachineController.getInstance(10);

        System.out.println("|");
        System.out.println("Filling up the inventory");
        System.out.println("|");
        fillUpInventory(controller);
        displayInventory(controller.getInventory());
        System.out.println("|");
        System.out.println("Inserting coins");
        System.out.println("|");
        controller.clickOnInsertCoinButton(Coin.TEN_RUPEES);
//        controller.clickOnInsertCoinButton(Coin.TEN_RUPEES);
        System.out.println("|");
        controller.clickOnStartProductSelectionButton(102);
        displayInventory(controller.getInventory());
    }

    private static void fillUpInventory(VendingMachineController vendingMachineController) {
        for (int i = 0; i < 10; i ++) {
            Item newItem = new Item();
            int codeNumber = 100 + i;
            if (i >= 0 && i < 3) {
                newItem.setType(ItemType.COKE);
                newItem.setPrice(20.0);
            } else if (i >= 3 && i < 5) {
                newItem.setType(ItemType.WATER);
                newItem.setPrice(10.0);
            } else if (i >= 5 && i < 7) {
                newItem.setType(ItemType.CHIPS);
                newItem.setPrice(50.0);
            } else if (i >= 7 && i < 10) {
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(30.0);
            }

            // Update the inventory with multiple same items per shelf
            for(int j = 0; j < 5; j ++) {
                vendingMachineController.updateInventory(newItem, codeNumber);
            }
        }
    }

    private static void displayInventory(Inventory inventory) {
        ItemShelf[] slots = inventory.getInventory();
        for (ItemShelf slot: slots) {
            List<Item> items = slot.getItems();
            if(!items.isEmpty()) {
                System.out.println("Code Number: " + slot.getCode() + " Items: ");
                for (Item item: items) {
                    System.out.println("Item: " + item.getType().name() + ", Price: " + item.getPrice());
                }
                System.out.println("SoldOut: " + slot.checkIsSoldOut());
            } else {
                System.out.println("CodeNumber: " + slot.getCode() + " Items: EMPTY"
                + " SoldOut: " + slot.checkIsSoldOut());
            }
        }
    }
}
