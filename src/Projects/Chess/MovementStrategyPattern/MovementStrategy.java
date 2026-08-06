package Projects.Chess.MovementStrategyPattern;


import Projects.Chess.Utility.Board;
import Projects.Chess.Utility.Cell;

public interface MovementStrategy {
    boolean canMove(Board board, Cell startCell, Cell endCell);
}
