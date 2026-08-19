package Projects.InventoryManagement.ProductFactoryPattern.ConcreteProducts;

import Projects.InventoryManagement.CommonEnums.ProductCategory;
import Projects.InventoryManagement.ProductFactoryPattern.Product;

public class GroceryProduct extends Product {

    double expiryDate;
    boolean refrigerated;

    public GroceryProduct(String sku, String name, double price, int quantity, ProductCategory category) {
        super(sku, name, price, quantity, category);
    }

    public double getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(double expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isRefrigerated() {
        return refrigerated;
    }

    public void setRefrigerated(boolean refrigerated) {
        this.refrigerated = refrigerated;
    }
}
