package Projects.TicTacToe.GameStateHandler.Context;

import Projects.TicTacToe.GameStateHandler.ConcreteState.GameState;
import Projects.TicTacToe.GameStateHandler.ConcreteState.XTurnState;
import Projects.TicTacToe.Utility.Player;

public class GameContext {
    private GameState currState;

    public GameContext() {
        this.currState = new XTurnState();
    }

    public void setState(GameState gameState) {
        this.currState = gameState;
    }

    public void  next(Player player, boolean hasWon) {
        currState.next(this, player, hasWon);
    }

    public boolean isGameOver() {
        return currState.isGameOver();
    }

    public GameState getCurrState() {
        return currState;
    }
}
