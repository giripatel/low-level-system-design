package Projects.VendingMachine.Utility;

import Projects.VendingMachine.CommonEnums.ItemType;

public class Item {
    int id;
    ItemType type;
    int quantity;
    double price;
    int threshold;

    public Item() {
//        this.type = type;
//        this.price = price;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
