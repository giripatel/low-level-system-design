package Projects.Chess.PieceFactoryPackage.ConcretePiece;

import Projects.Chess.PieceFactoryPackage.Piece;
import Projects.Chess.MovementStrategyPattern.ConcreteMovementStrategies.KnightMovementStrategy;

public class Knight extends Piece {
    public Knight(boolean isWhite) {
        super(isWhite, new KnightMovementStrategy());
    }
}
