package Projects.Chess.Utility;

public class Board {

    private static Board instance;
    Cell[][] board;

    private Board(int rows) {
        initializeBoard(rows);
    }

    public static Board getInstance(int rows){
        if (instance == null) {
            instance = new Board(rows);
        }
        return instance;
    }

    private void initializeBoard(int rows) {
        this.board = new Cell[rows][rows];
    }
}
