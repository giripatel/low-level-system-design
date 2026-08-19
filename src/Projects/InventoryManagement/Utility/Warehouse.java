package Projects.InventoryManagement.Utility;

import Projects.InventoryManagement.ProductFactoryPattern.Product;

import java.util.*;

public class Warehouse {
    int id;
    String name;
    String location;
    Map<String, Product> productMap;

    public Warehouse(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.productMap = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        String sku = product.getSku();
        if (productMap.containsKey(sku)) {

            product.setQuantity(product.getQuantity() + quantity);
        } else {
            productMap.put(sku, product);
        }
    }

    public boolean removeProduct(String sku, int quantity) {
        if (productMap.containsKey(sku)) {
            int currentQuantity = productMap.get(sku).getQuantity();
            if(currentQuantity >= quantity) {
                productMap.get(sku).setQuantity(currentQuantity - quantity);
            } else {
                System.out.println("Has less quantity");
            }

            if(currentQuantity - quantity == 0) productMap.remove(sku);

            return true;
        } else {
            return false;
        }
    }

    public int getAvailableQuantity(String sku) {
       if (productMap.containsKey(sku)) {
           return getProductBySku(sku).getQuantity();
       }
       return 0;
    }

    public Product getProductBySku(String sku) {
        return productMap.get(sku);
    }

    public Collection<Product> getAllProducts() {
        return productMap.values();
    }
}
