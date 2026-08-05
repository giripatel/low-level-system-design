package Practice.TicTacToe.P1.Strategy.ConcreteStrategy;

import Practice.TicTacToe.P1.Strategy.PlayerStrategy;
import Practice.TicTacToe.P1.Utility.Board;
import Practice.TicTacToe.P1.Utility.Position;


import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {

    String name;

    public HumanPlayerStrategy(String name) {
        this.name = name;
    }

    @Override
    public Position makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter your position in row [0-2] and col [0-2]");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Position position = new Position(row, col);

            if(board.isValidMove(position)) {
                return position;
            }

            System.out.println("Invalid move");
        }
    }
}
