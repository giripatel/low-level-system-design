package Practice.TicTacToe.P1.GameStateHandler;

import Practice.TicTacToe.P1.GameStateHandler.GameContext;
import Practice.TicTacToe.P1.Utility.Player;

public interface GameState {
    void next(Player player, GameContext context, boolean isWon);
    boolean isGameOver();
}
