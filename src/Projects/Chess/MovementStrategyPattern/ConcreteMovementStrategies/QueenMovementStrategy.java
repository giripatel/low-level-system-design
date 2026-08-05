package Projects.Chess.MovementStrategyPattern.ConcreteMovementStrategies;

import Practice.TicTacToe.P1.Utility.Board;
import Projects.Chess.MovementStrategyPattern.MovementStrategy;
import Projects.Chess.Utility.Cell;

public class QueenMovementStrategy implements MovementStrategy {
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
