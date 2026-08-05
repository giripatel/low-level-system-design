package Projects.Chess.PieceFactoryPackage.ConcretePiece;

import Projects.Chess.PieceFactoryPackage.Piece;
import Projects.Chess.MovementStrategyPattern.ConcreteMovementStrategies.BishopMovementStrategy;

public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super(isWhite, new BishopMovementStrategy());
    }
}
