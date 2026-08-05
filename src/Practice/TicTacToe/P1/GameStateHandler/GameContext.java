package Practice.TicTacToe.P1.GameStateHandler;

import Practice.TicTacToe.P1.GameStateHandler.ConcreteStates.XTurnState;
import Practice.TicTacToe.P1.Utility.Player;

public class GameContext {
    GameState currentState;

    public GameContext() {
        this.currentState = new XTurnState();
    }

    public void setState(GameState state) {
        currentState = state;
    }

    public void next(Player player, boolean isWon) {
        currentState.next(player, this, isWon);
    }

    public boolean isGameOver() {
        return currentState.isGameOver();
    }
    public GameState getCurrentState() {
        return currentState;
    }
}
