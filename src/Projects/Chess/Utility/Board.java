package Projects.Chess.Utility;

import Projects.Chess.PieceFactoryPackage.PieceFactory;

public class Board {

    int rows;
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

        setPieceRow(0, true);
        setPieceRow(1, rows,true);

        setPieceRow(rows - 1, false);
        setPieceRow(rows - 2, rows,false);

        for (int row = 2; row < rows - 2; row ++) {
            for (int i = 0; i < rows; i++) {
                board[row][i] = new Cell(row, i, null);
            }
        }
    }

    private void setPieceRow(int row, boolean isWhite) {
        board[row][0] = new Cell(row, 0, PieceFactory.createPiece("bishop", isWhite));
        board[row][1] = new Cell(row, 1, PieceFactory.createPiece("knight", isWhite));
        board[row][2] = new Cell(row, 2, PieceFactory.createPiece("rook", isWhite));
        board[row][3] = new Cell(row, 3, PieceFactory.createPiece("king", isWhite));
        board[row][4] = new Cell(row, 4, PieceFactory.createPiece("queen", isWhite));
        board[row][5] = new Cell(row, 5, PieceFactory.createPiece("rook", isWhite));
        board[row][6] = new Cell(row, 6, PieceFactory.createPiece("knight", isWhite));
        board[row][7] = new Cell(row, 7, PieceFactory.createPiece("bishop", isWhite));
    }

    private void setPieceRow(int row, int rows, boolean isWhite) {
        for (int i = 0; i < rows; i++) {
            board[row][i] = new Cell(row, i, PieceFactory.createPiece("pawn", isWhite));
        }
    }

    public Cell getCell(int row, int col) {
        if(row >= 0 && row < rows && col >= 0 && col < rows) {
            return board[row][col];
        }
        return null;
    }
}
