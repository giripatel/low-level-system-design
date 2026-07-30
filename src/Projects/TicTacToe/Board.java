package Projects.TicTacToe;

public class Board {
    int rows;
    int columns;
    Symbol[][] grid;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new Symbol[rows][columns];
    }

    boolean isValidMove(Position position) {
        return position.row >= 0 && position.row < rows && position.col >= 0 && position.col < columns && grid[position.row][position.col] == Symbol.EMPTY;
    }

    public void makeMove(Position position, Symbol symbol) {

    }

    public void checkGameState(GameContext gameContext) {

    }

    public boolean isWinningMove(Symbol[] row) {

    }
}
