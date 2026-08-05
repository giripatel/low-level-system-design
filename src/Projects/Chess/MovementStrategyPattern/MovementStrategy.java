package Projects.Chess.MovementStrategyPattern;

import Practice.TicTacToe.P1.Utility.Board;
import Projects.Chess.Utility.Cell;

public interface MovementStrategy {
    boolean canMove(Board board, Cell startCell, Cell endCell);
}
