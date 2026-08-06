package Projects.Chess.Controller;

import Projects.Chess.CommonEnums.Status;
import Projects.Chess.PieceFactoryPackage.ConcretePiece.King;
import Projects.Chess.PieceFactoryPackage.Piece;
import Projects.Chess.Utility.Board;
import Projects.Chess.Utility.Cell;
import Projects.Chess.Utility.Move;
import Projects.Chess.Utility.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class ChessGame implements BoardGame{
    Board board;
    Player player1;
    Player player2;
    boolean isWhiteTurn;
    ArrayList<Move> gameLog;
    Status gameStatus;

    public ChessGame(Player player1, Player player2, int rows) {
        this.board = Board.getInstance(rows);
        this.player1 = player1;
        this.player2 = player2;
        this.isWhiteTurn = true;
        this.gameStatus = Status.ACTIVE;
        this.gameLog = new ArrayList<>();
    }

    /**
     *
     */
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (gameStatus == Status.ACTIVE) {

            Player currentPlayer = isWhiteTurn? player1 : player2;
            System.out.println(currentPlayer.getName() + "'s turn (" + (currentPlayer.isWhiteSide()? "White" :"Black") + ")");

            // Ask for source coordinates
            System.out.println("Enter source row and column (e.g., 6 4) : ");
            int startRow = scanner.nextInt();
            int startCol = scanner.nextInt();

            int endRow = scanner.nextInt();
            int endCol = scanner.nextInt();

            Cell startCell = board.getCell(startRow, startCol);
            Cell endCell = board.getCell(endRow, endCol);

            if(startCell == null || startCell.getPiece() == null) {
                System.out.println("Invalid move: No piece at source cell.");
                continue;
            }

            makeMove(new Move(startCell, endCell), currentPlayer);
        }

        System.out.println("Game Over! Status: " + this.gameStatus);

    }

    public void makeMove(Move move, Player player) {

        if(move.isValid()) {

            Piece sourcePiece = move.getStartCell().getPiece();

            if(sourcePiece.canMove(board, move.getStartCell(), move.getEndCell())) {
                Piece destinationPiece = move.getEndCell().getPiece();

                if(destinationPiece != null) {
                    // If the destination cell contains king and currently white is playing
                    // white will win
                    if(destinationPiece instanceof King && isWhiteTurn) {
                        this.gameStatus = Status.WHITE_WIN;
                        return;
                    }
                    // if black is playing
                    if(destinationPiece instanceof King && !isWhiteTurn) {
                        this.gameStatus = Status.BLACK_WIN;
                        return;
                    }

                    // Set the destination piece as killed
                    destinationPiece.setKilled(true);
                }

                gameLog.add(move);

                move.getEndCell().setPiece(sourcePiece);
                move.getStartCell().setPiece(null);
                System.out.println(isWhiteTurn);
            }
        }
    }
}
