package Projects.TicTacToe.GameStateHandler.ConcreteState;

import Projects.TicTacToe.GameStateHandler.Context.GameContext;
import Projects.TicTacToe.Utility.Player;

public interface GameState {
    void next(GameContext context, Player player, boolean hasWon);
    boolean isGameOver();
}
