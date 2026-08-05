package Projects.TicTacToe.GameStateHandler.ConcreteState;

import Projects.TicTacToe.GameStateHandler.Context.GameContext;
import Projects.TicTacToe.Utility.Player;

public class XWonState implements GameState {

    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        // Game over no next state
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
