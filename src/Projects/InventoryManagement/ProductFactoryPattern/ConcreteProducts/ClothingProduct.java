package Projects.InventoryManagement.ProductFactoryPattern.ConcreteProducts;

import Projects.InventoryManagement.CommonEnums.ProductCategory;
import Projects.InventoryManagement.ProductFactoryPattern.Product;

public class ClothingProduct extends Product {

    String color;
    int size;

    public ClothingProduct(String sku, String name, double price, int quantity, ProductCategory category) {
        super(sku, name, price, quantity, category);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
