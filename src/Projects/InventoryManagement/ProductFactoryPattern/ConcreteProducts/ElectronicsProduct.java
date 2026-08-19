package Projects.InventoryManagement.ProductFactoryPattern.ConcreteProducts;

import Projects.InventoryManagement.CommonEnums.ProductCategory;
import Projects.InventoryManagement.ProductFactoryPattern.Product;

public class ElectronicsProduct extends Product {
    String brand;
    int warrantyPeriod;

    public ElectronicsProduct(String sku, String name, double price, int quantity, ProductCategory category) {
        super(sku, name, price, quantity, category);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
}
