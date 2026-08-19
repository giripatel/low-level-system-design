package Projects.InventoryManagement.ReplinishmentStrategyPattern;

import Projects.InventoryManagement.ProductFactoryPattern.Product;

public interface ReplenishmentStrategy {
    void replenish(Product product);
}
