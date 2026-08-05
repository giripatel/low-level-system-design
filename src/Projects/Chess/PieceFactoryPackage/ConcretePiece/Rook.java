package Projects.Chess.PieceFactoryPackage.ConcretePiece;

import Projects.Chess.PieceFactoryPackage.Piece;
import Projects.Chess.MovementStrategyPattern.ConcreteMovementStrategies.RookMovementStrategy;

public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite, new RookMovementStrategy());
    }
}
