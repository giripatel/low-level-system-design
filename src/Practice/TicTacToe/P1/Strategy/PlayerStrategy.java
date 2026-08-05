package Practice.TicTacToe.P1.Strategy;


import Practice.TicTacToe.P1.Utility.Board;
import Practice.TicTacToe.P1.Utility.Position;

public interface PlayerStrategy {
    public Position makeMove(Board board);
}
