package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Prototype.Problem;

public class Main {
    public static void main(String[] args) {

        GameBoard board = new GameBoard();
        board.addGamePiece(new GamePiece("orange", 1));
        board.addGamePiece(new GamePiece("green", 2));
        board.addGamePiece(new GamePiece("pink", 3));
        board.addGamePiece(new GamePiece("yellow", 4));

        System.out.println(board.getBoard());
        GameBoard copiedBoard = new GameBoard();
        for(GamePiece piece: board.getBoard()) {
            copiedBoard.addGamePiece(new GamePiece(piece.getColor(), piece.getPosition()));
        }
        System.out.println(copiedBoard.getBoard());
    }
}
