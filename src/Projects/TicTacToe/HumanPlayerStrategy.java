package Projects.TicTacToe;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {

    Scanner scanner;
    String playerName;

    public HumanPlayerStrategy(String playerName) {
        this.playerName = playerName;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Position makeMove(Board board) {

        while (true) {
            System.out.println("enter your move (row [0-2] col[0-2]) " + playerName);
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                Position position = new Position(row, col);
                if (board.isValidMove(position)) {
                    return position;
                }
                System.out.println("Invalid move try again..,");
            } catch (Exception e) {
                System.out.println("Invalid move try again");
            }
        }
    }
}
