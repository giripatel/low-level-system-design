package Projects.Chess.PieceFactoryPackage;

import Projects.Chess.MovementStrategyPattern.MovementStrategy;

public abstract class Piece {

    boolean isWhite;
    boolean isKilled;
    MovementStrategy strategy;

    public Piece(boolean isWhite, MovementStrategy strategy) {
        this.isWhite = isWhite;
        this.isKilled = false;
        this.strategy = strategy;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public boolean isWhite() {
        return isWhite;
    }
}
