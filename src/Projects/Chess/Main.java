package Projects.Chess;

import Projects.Chess.Controller.ChessGame;
import Projects.Chess.Utility.Player;

public class Main {
    public static void main(String[] args) {
        // Create Players
        Player player1 = new Player("Player1", true);
        Player player2 = new Player("Player2", false);

        ChessGame game = new ChessGame(player1, player1, 8);
        game.start();
    }
}
