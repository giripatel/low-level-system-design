package Projects.TicTacToe;

import Projects.TicTacToe.Controller.GameController.TicTacToeGame;
import Projects.TicTacToe.PlayerStrategies.ConcreteStrategies.HumanPlayerStrategy;
import Projects.TicTacToe.PlayerStrategies.PlayerStrategy;

public class Main {
    public static void main(String[] args) {
        PlayerStrategy playerStrategy1 = new HumanPlayerStrategy("Laddu");
        PlayerStrategy playerStrategy2 = new HumanPlayerStrategy("Guddu");

        TicTacToeGame game = new TicTacToeGame(playerStrategy1, playerStrategy2, 3, 3);
        game.play();
    }
}
