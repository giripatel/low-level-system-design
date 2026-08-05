package Projects.Chess.PieceFactoryPackage.ConcretePiece;

import Projects.Chess.PieceFactoryPackage.Piece;
import Projects.Chess.MovementStrategyPattern.ConcreteMovementStrategies.QueenMovementStrategy;

public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite, new QueenMovementStrategy());
    }
}
