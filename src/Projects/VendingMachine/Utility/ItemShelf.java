package Projects.VendingMachine.Utility;

import java.util.ArrayList;
import java.util.List;

public class ItemShelf {
    int code;
    List<Item> items;
    boolean isSoldOut;

    public ItemShelf(int code) {
        this.code = code;
        this.items = new ArrayList<>();
        this.isSoldOut = false;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        if (isSoldOut) setSoldOut(false);
    }

    public void addItem(Item item) {
        items.add(item);
        if (isSoldOut) setSoldOut(false);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Item getItem() {
        if (!items.isEmpty()) {
            return items.get(0);
        }
        return null;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }

    public void removeItem(Item item) {
        items.remove(item);
        if (items.isEmpty()) setSoldOut(true);
    }

    public boolean checkIsSoldOut() {
        return isSoldOut;
    }
}
