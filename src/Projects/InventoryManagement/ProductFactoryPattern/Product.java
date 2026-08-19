package Projects.InventoryManagement.ProductFactoryPattern;

import Projects.InventoryManagement.CommonEnums.ProductCategory;

public abstract class Product {
    String sku;
    String name;
    double price;
    int quantity;
    int threshold;
    ProductCategory category;

    public Product(String sku, String name, double price, int quantity,  ProductCategory category) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getThreshold() {
        return threshold;
    }

    public void addStock() {

    }

    public void removeStock() {

    }
}
