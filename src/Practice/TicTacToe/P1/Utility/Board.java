package Practice.TicTacToe.P1.Utility;

import Practice.TicTacToe.P1.GameStateHandler.GameContext;
import Practice.TicTacToe.P1.Utility.Position;
import Practice.TicTacToe.P1.Utility.Player;

public class Board {
    int rows;
    int cols;
    Symbol[][] grid;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Symbol[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }


    public void makeMove(Player player, Position position) {
        grid[position.row][position.col] = player.getSymbol();
    }
    public boolean isValidMove(Position position) {
        return position.row >= 0 && position.row < rows && position.col >= 0 && position.col < cols && grid[position.row][position.col] == Symbol.EMPTY;
    }

    public void checkGameState(Player player, GameContext context) {

        for (int i = 0; i < rows; i ++) {
            Symbol symbol = grid[i][0];
            if (symbol != Symbol.EMPTY && isWinningLine(grid[i])) {
                context.next(player, true);
                return;
            }
        }

        for (int i = 0; i < cols; i ++) {
            Symbol symbol = grid[0][i];
            if (symbol != Symbol.EMPTY) {
                Symbol[] column = new Symbol[cols];
                for (int j = 0; j < cols; j++) {
                    column[j] = grid[j][i];
                }
                if (isWinningLine(column)) {
                    context.next(player, true);
                    return;
                }
            }
        }

        Symbol[] diagonal1 = new Symbol[Math.min(rows, cols)];
        Symbol[] diagonal2 = new Symbol[Math.min(rows, cols)];
            for (int i = 0; i < cols; i ++) {
                diagonal1[i] = grid[i][i];
                diagonal2[i] = grid[i][rows - i - 1];
            }

            if (diagonal1[0] != Symbol.EMPTY && isWinningLine(diagonal1)) {
                context.next(player, true);
                return;
            }

            if (diagonal2[0] != Symbol.EMPTY && isWinningLine(diagonal2)) {
                context.next(player, true);
            }
    }

    public boolean isWinningLine(Symbol[] line) {
        Symbol firstSymbol = line[0];

        for (Symbol symbol: line) {
            if(symbol != firstSymbol) return false;
        }
        return true;
    }

    public void printBoard() {

        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j++) {
                Symbol symbol = grid[i][j];

                switch (symbol) {
                    case X -> System.out.print(" X ");
                    case O -> System.out.print(" O ");
                    case EMPTY -> System.out.print(" . ");
                }

                if(j < cols - 1) {
                    System.out.print(" | ");
                } else {
                    System.out.println();
                }
            }

            if(i < rows - 1) {
                System.out.println("------+------+------");
            }
        }
    }
}
