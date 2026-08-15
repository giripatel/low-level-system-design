package Projects.Chess.MovementStrategyPattern.ConcreteMovementStrategies;

import Projects.Chess.MovementStrategyPattern.MovementStrategy;
import Projects.Chess.Utility.Board;
import Projects.Chess.Utility.Cell;

public class BishopMovementStrategy implements MovementStrategy {
    /**
     * @param board 
     * @param startCell
     * @param endCell
     * @return
     */
    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        return false;
    }
}
