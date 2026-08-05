package Projects.TicTacToe.Utility;

import Projects.TicTacToe.CommonEnum.Symbol;
import Projects.TicTacToe.GameStateHandler.ConcreteState.DrawState;
import Projects.TicTacToe.GameStateHandler.Context.GameContext;

public class Board {
    int rows;
    int columns;
    Symbol[][] grid;
    int totalColumnsOccupied = 0;
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new Symbol[rows][columns];

        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < columns; j ++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position position) {
        return position.row >= 0 && position.row < rows && position.col >= 0 && position.col < columns && grid[position.row][position.col] == Symbol.EMPTY;
    }

    public void makeMove(Position position, Symbol symbol) {
        totalColumnsOccupied ++;
        grid[position.row][position.col] = symbol;
    }

    public void checkGameState(GameContext gameContext, Player currentPlayer) {
        for(int i = 0; i < rows; i ++) {
            if(grid[i][0] != Symbol.EMPTY && isWinningMove(grid[i])) {
                gameContext.next(currentPlayer, true);
                return;
            }
        }

        for(int i = 0; i < columns; i ++) {
            Symbol[] column = new Symbol[rows];
            for(int j = 0; j < rows; j ++) {
                column[j] = grid[j][i];
            }
            if(column[0] != Symbol.EMPTY && isWinningMove(column)) {
                gameContext.next(currentPlayer, true);
                return;
            }
        }

        Symbol[] diagonal1 = new Symbol[Math.min(rows, columns)];
        Symbol[] diagonal2 = new Symbol[Math.min(rows, columns)];

        for (int i = 0; i < Math.min(rows, columns); i++) {
            diagonal1[i] = grid[i][i];
            diagonal2[i] = grid[i][columns - i -1];
        }

        if (diagonal1[0] != Symbol.EMPTY && isWinningMove(diagonal1)) {
            gameContext.next(currentPlayer, true);
            return;
        }

        if (diagonal2[0] != Symbol.EMPTY && isWinningMove(diagonal2)) {
            gameContext.next(currentPlayer, true);
        }

        if(totalColumnsOccupied == rows * columns) {
            gameContext.setState(new DrawState());
        }
    }

    public boolean isWinningMove(Symbol[] line) {
        Symbol first = line[0];

        for (Symbol s : line) {
            if (s != first) {
                return false;
            }
        }

        return true;
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Symbol symbol = grid[i][j];

                switch (symbol) {
                    case X -> System.out.print(" X ");
                    case O -> System.out.print(" O ");
                    case EMPTY -> System.out.print(" . ");
                }

                if(j < columns - 1) {
                    System.out.print(" | ");
                }
            }

            System.out.println();
            if(i < rows - 1) {
                System.out.println("----+-----+-----");
            }
        }
        System.out.println();
    }

}
