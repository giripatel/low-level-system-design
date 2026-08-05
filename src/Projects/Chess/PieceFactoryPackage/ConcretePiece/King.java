package Projects.Chess.PieceFactoryPackage.ConcretePiece;

import Projects.Chess.PieceFactoryPackage.Piece;
import Projects.Chess.MovementStrategyPattern.ConcreteMovementStrategies.KingMovementStrategy;

public class King extends Piece {
    public King(boolean isWhite) {
        super(isWhite, new KingMovementStrategy());
    }
}
