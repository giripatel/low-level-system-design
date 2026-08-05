package Projects.Chess.PieceFactoryPackage.ConcretePiece;

import Projects.Chess.PieceFactoryPackage.Piece;
import Projects.Chess.MovementStrategyPattern.ConcreteMovementStrategies.PawnMovementStrategy;

public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite, new PawnMovementStrategy());
    }
}
