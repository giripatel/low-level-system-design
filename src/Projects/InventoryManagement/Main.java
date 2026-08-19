package Projects.InventoryManagement;

import Projects.InventoryManagement.CommonEnums.ProductCategory;
import Projects.InventoryManagement.InventoryController.InventoryManager;
import Projects.InventoryManagement.ProductFactoryPattern.ConcreteProducts.ElectronicsProduct;
import Projects.InventoryManagement.ProductFactoryPattern.Product;
import Projects.InventoryManagement.ProductFactoryPattern.ProductFactory;
import Projects.InventoryManagement.ReplinishmentStrategyPattern.ConcreteStratagies.JITStrategy;
import Projects.InventoryManagement.ReplinishmentStrategyPattern.ReplenishmentStrategy;
import Projects.InventoryManagement.Utility.Warehouse;

public class Main {
    public static void main(String[] args) {
        ReplenishmentStrategy replenishmentStrategy = new JITStrategy();
        InventoryManager inventoryManager = InventoryManager.getInstance(replenishmentStrategy);

        Warehouse warehouse1 = new Warehouse(1, "W1", "Manikonda");
        Warehouse warehouse2 = new Warehouse(2, "W2", "Gach");
        inventoryManager.addWarehouse(warehouse1);
        inventoryManager.addWarehouse(warehouse2);

        // Create products using ProductFactory
        ProductFactory productFactory = new ProductFactory();
        Product laptop = productFactory.createProduct(
                "SKU123", "Laptop", 1000.0, 50, ProductCategory.ELECTRONICS);
        Product tShirt = productFactory.createProduct(
                 "SKU456", "T-Shirt", 20.0, 200, ProductCategory.CLOTHING);
        Product apple = productFactory.createProduct(
                "SKU789", "Apple", 1.0, 100, ProductCategory.GROCERY);

        // Add products to warehouses
        warehouse1.addProduct(laptop, 15);
        warehouse1.addProduct(tShirt, 20);
        warehouse2.addProduct(apple, 50);

        for (Warehouse warehouse: inventoryManager.getWarehouses()) {
            System.out.println(warehouse.getAllProducts());
        }
    }
}
