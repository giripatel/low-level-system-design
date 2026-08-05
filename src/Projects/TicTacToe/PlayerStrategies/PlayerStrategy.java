package Projects.TicTacToe.PlayerStrategies;

import Projects.TicTacToe.Utility.Board;
import Projects.TicTacToe.Utility.Position;

public interface PlayerStrategy {
    Position makeMove(Board b);
}
