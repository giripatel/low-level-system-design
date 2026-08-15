package Projects.SnakeAndFoodGame.MovementStrategies.ConcreteMovementStrategies;

import Projects.SnakeAndFoodGame.MovementStrategies.MovementStrategy;
import Projects.SnakeAndFoodGame.UtilityClasses.Pair;

public class AIMovementStrategy implements MovementStrategy {
    /**
     * @param currentHead 
     * @param direction
     * @return
     */
    @Override
    public Pair getNextPosition(Pair currentHead, String direction) {
        // AI logic to determine next best move based on food position and obstacles
        return currentHead;
    }
}
