package Projects.InventoryManagement.ProductFactoryPattern;

import Projects.InventoryManagement.CommonEnums.ProductCategory;
import Projects.InventoryManagement.ProductFactoryPattern.ConcreteProducts.ClothingProduct;
import Projects.InventoryManagement.ProductFactoryPattern.ConcreteProducts.ElectronicsProduct;
import Projects.InventoryManagement.ProductFactoryPattern.ConcreteProducts.GroceryProduct;

public class ProductFactory {

    public static Product createProduct(String sku, String name, double price, int quantity, ProductCategory category) {
        switch (category) {
            case GROCERY -> {
                return new GroceryProduct(sku, name, price, quantity, category);
            }
            case CLOTHING -> {
                return new ClothingProduct(sku, name, price, quantity, category);
            }
            case ELECTRONICS -> {
                return new ElectronicsProduct(sku, name, price, quantity, category);
            }
            default -> throw new IllegalArgumentException("product not found");
        }
    }
}
