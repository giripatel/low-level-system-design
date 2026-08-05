package Practice.TicTacToe.P1.GameStateHandler.ConcreteStates;

import Practice.TicTacToe.P1.GameStateHandler.GameContext;
import Practice.TicTacToe.P1.GameStateHandler.GameState;
import Practice.TicTacToe.P1.Utility.Player;
import Practice.TicTacToe.P1.Utility.Symbol;

public class XWonState implements GameState {

    @Override
    public void next(Player player, GameContext context, boolean isWon) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
