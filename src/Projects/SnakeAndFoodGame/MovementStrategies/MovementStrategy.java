package Projects.SnakeAndFoodGame.MovementStrategies;

import Projects.SnakeAndFoodGame.UtilityClasses.Pair;

public interface MovementStrategy {
    Pair getNextPosition(Pair currentHead, String direction);
}
