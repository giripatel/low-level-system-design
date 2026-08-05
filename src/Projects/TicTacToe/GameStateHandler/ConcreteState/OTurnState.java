package Projects.TicTacToe.GameStateHandler.ConcreteState;

import Projects.TicTacToe.GameStateHandler.Context.GameContext;
import Projects.TicTacToe.Utility.Player;
import Projects.TicTacToe.CommonEnum.Symbol;

public class OTurnState implements GameState {

    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        if (hasWon) {
            context.setState(player.getSymbol() == Symbol.O? new OWonState() : new XTurnState());
        } else {
            context.setState(new XTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
