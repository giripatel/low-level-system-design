package Projects.Chess.Utility;

import Projects.Chess.PieceFactoryPackage.Piece;

public class Cell {
    int row;
    int col;
    String label;
    Piece piece;

    public Cell(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
