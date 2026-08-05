package Projects.TicTacToe.GameStateHandler.ConcreteState;

import Projects.TicTacToe.GameStateHandler.Context.GameContext;
import Projects.TicTacToe.Utility.Player;

public class OWonState implements GameState {

    @Override
    public void next(GameContext context, Player player, boolean hasWon) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
