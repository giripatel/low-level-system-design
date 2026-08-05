package Practice.TicTacToe.P1;

import Practice.TicTacToe.P1.GameController.Controller.TicTacToe;
import Practice.TicTacToe.P1.Strategy.ConcreteStrategy.HumanPlayerStrategy;
import Practice.TicTacToe.P1.Strategy.PlayerStrategy;

public class Main {
    public static void main(String[] args) {
        PlayerStrategy playerStrategy1 = new HumanPlayerStrategy("Golo");
        PlayerStrategy playerStrategy2 = new HumanPlayerStrategy("Molo");

        TicTacToe game = new TicTacToe(playerStrategy1, playerStrategy2, 3, 3);
        game.play();
    }
}
