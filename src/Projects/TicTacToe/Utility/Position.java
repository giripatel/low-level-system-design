package Projects.TicTacToe.Utility;

public class Position {
    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public String toString() {
        return "row : " + row + " - col : " + col;
    }
}
