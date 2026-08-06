package Projects.Chess.PieceFactoryPackage;

import Projects.Chess.MovementStrategyPattern.ConcreteMovementStrategies.KnightMovementStrategy;
import Projects.Chess.PieceFactoryPackage.ConcretePiece.*;

public class PieceFactory {

    public static Piece createPiece(String symbol, boolean isWhite) {

        switch (symbol.toLowerCase()) {
            case "king" -> {
                return new King(isWhite);
            }
            case "knight" -> {
                return new Knight(isWhite);
            }
            case "rook" -> {
                return new Rook(isWhite);
            }
            case "bishop" -> {
                return new Bishop(isWhite);
            }
            case "pawn" -> {
                return new Pawn(isWhite);
            }
            case "queen" -> {
                return new Queen(isWhite);
            }
            default -> {
                throw new IllegalArgumentException("invalid input");
            }
        }
    }
}
