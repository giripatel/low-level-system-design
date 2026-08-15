package Projects.SnakeAndFoodGame.MovementStrategies.ConcreteMovementStrategies;

import Projects.SnakeAndFoodGame.MovementStrategies.MovementStrategy;
import Projects.SnakeAndFoodGame.UtilityClasses.Pair;

public class HumanMovementStrategy implements MovementStrategy {
    /**
     * @param currentHead 
     * @param direction
     * @return
     */
    @Override
    public Pair getNextPosition(Pair currentHead, String direction) {

        int row = currentHead.getRow();
        int col = currentHead.getCol();

        return switch (direction) {
            case "U" -> new Pair(row - 1, col - 1);
            case "D" -> new Pair(row + 1, col + 1);
            case "L" -> new Pair(row, col - 1);
            case "R" -> new Pair(row, col + 1);
            default -> currentHead;
        };
    }
}
