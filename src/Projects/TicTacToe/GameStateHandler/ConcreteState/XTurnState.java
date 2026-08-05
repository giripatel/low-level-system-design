package Projects.TicTacToe.GameStateHandler.ConcreteState;

import Projects.TicTacToe.GameStateHandler.Context.GameContext;
import Projects.TicTacToe.Utility.Player;
import Projects.TicTacToe.CommonEnum.Symbol;

public class XTurnState implements GameState {

    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        if(hasWon) {
            context.setState(player.getSymbol() == Symbol.X? new XWonState() : new OWonState());
        } else {
            context.setState(new OTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
