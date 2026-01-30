package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Prototype.Problem;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private List<GamePiece> board = new ArrayList<>();

    public void addGamePiece(GamePiece piece) {
        this.board.add(piece);
    }

    public List<GamePiece> getBoard() {
        return board;
    }
}
