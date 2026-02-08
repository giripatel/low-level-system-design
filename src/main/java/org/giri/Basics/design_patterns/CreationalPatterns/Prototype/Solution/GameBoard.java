package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Prototype.Solution;

import java.util.ArrayList;
import java.util.List;

public class GameBoard implements Prototype<GameBoard> {

    private List<GamePiece> board = new ArrayList<>();

    public void addGamePiece(GamePiece piece) {
        this.board.add(piece);
    }

    public List<GamePiece> getBoard() {
        return board;
    }

    public GameBoard clone() {
        GameBoard clone = new GameBoard();
        for(GamePiece piece: board) {
            clone.addGamePiece(piece.clone());
        }
        return clone;
    }
}
