package Projects.InventoryManagement.InventoryController;

import Projects.InventoryManagement.ProductFactoryPattern.Product;
import Projects.InventoryManagement.ProductFactoryPattern.ProductFactory;
import Projects.InventoryManagement.ReplinishmentStrategyPattern.ReplenishmentStrategy;
import Projects.InventoryManagement.Utility.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private static InventoryManager instance;
    List<Warehouse> warehouses;
    ProductFactory productFactory;
    ReplenishmentStrategy replenishmentStrategy;

    private InventoryManager(ReplenishmentStrategy replenishmentStrategy) {
        this.replenishmentStrategy = replenishmentStrategy;
        this.productFactory = new ProductFactory();
        this.warehouses = new ArrayList<>();
    }

    public static InventoryManager getInstance(ReplenishmentStrategy replenishmentStrategy) {
        if (instance == null) {
            instance = new InventoryManager(replenishmentStrategy);
        }
        return instance;
    }

    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse) {
        warehouses.remove(warehouse);
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public Product getProductBySku(String sku) {
        for (Warehouse warehouse: warehouses) {
            Product product = warehouse.getProductBySku(sku);
            if (sku == product.getSku()) return product;
        }
        return null;
    }

    public void setReplenishmentStrategy(ReplenishmentStrategy replenishmentStrategy) {
        this.replenishmentStrategy = replenishmentStrategy;
    }

    public void checkAndReplenish(String sku) {
        Product product = getProductBySku(sku);
        if(product != null) {
            if (product.getQuantity() < product.getThreshold()) {
                if (replenishmentStrategy != null) {
                    replenishmentStrategy.replenish(product);
                }
            }
        }

    }

    public void performInventoryCheck() {
        for (Warehouse warehouse: warehouses) {
            List<Product> products = (List<Product>) warehouse.getAllProducts();
            for (Product product: products) {
                if(product.getQuantity() < product.getThreshold()) {
                    if (replenishmentStrategy != null) replenishmentStrategy.replenish(product);
                }
            }
        }
    }

    private void notifyObservers(Product product) {

    }
}
