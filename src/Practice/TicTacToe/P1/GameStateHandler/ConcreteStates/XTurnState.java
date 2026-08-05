package Practice.TicTacToe.P1.GameStateHandler.ConcreteStates;

import Practice.TicTacToe.P1.GameStateHandler.GameContext;
import Practice.TicTacToe.P1.GameStateHandler.GameState;
import Practice.TicTacToe.P1.Utility.Player;
import Practice.TicTacToe.P1.Utility.Symbol;

public class XTurnState implements GameState {

    @Override
    public void next(Player player, GameContext context, boolean isWon) {
        if (isWon) {
            context.setState(player.getSymbol() == Symbol.X? new XWonState() : new OWonState());
        } else {
            context.setState(new XTurnState());
        }
    }

    public boolean isGameOver() {
        return false;
    }
}
