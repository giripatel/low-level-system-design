package Projects.InventoryManagement.ReplinishmentStrategyPattern.ConcreteStratagies;

import Projects.InventoryManagement.ProductFactoryPattern.Product;
import Projects.InventoryManagement.ReplinishmentStrategyPattern.ReplenishmentStrategy;

public class JITStrategy implements ReplenishmentStrategy {
    /**
     * @param product
     */
    @Override
    public void replenish(Product product) {
        System.out.println("Applying JIT strategy");
    }
}
