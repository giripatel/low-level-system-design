package Projects.SnakeAndFoodGame.FoodItemFactory;

import Projects.SnakeAndFoodGame.FoodItemFactory.ConcreteFoodItems.BonusFood;
import Projects.SnakeAndFoodGame.FoodItemFactory.ConcreteFoodItems.NormalFood;

public class FoodFactory {

    public static FoodItem createFood(int row, int col, String type) {
        if ("bonus".equals(type)) {
            return new BonusFood(row, col);
        }
        return new NormalFood(row, col);
    }
}
