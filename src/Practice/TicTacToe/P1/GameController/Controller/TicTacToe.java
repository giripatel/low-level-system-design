package Practice.TicTacToe.P1.GameController.Controller;

import Practice.TicTacToe.P1.GameController.BoardGame;
import Practice.TicTacToe.P1.GameStateHandler.ConcreteStates.OWonState;
import Practice.TicTacToe.P1.GameStateHandler.ConcreteStates.XTurnState;
import Practice.TicTacToe.P1.GameStateHandler.ConcreteStates.XWonState;
import Practice.TicTacToe.P1.GameStateHandler.GameContext;
import Practice.TicTacToe.P1.GameStateHandler.GameState;
import Practice.TicTacToe.P1.Strategy.PlayerStrategy;
import Practice.TicTacToe.P1.Utility.Board;
import Practice.TicTacToe.P1.Utility.Player;
import Practice.TicTacToe.P1.Utility.Position;
import Practice.TicTacToe.P1.Utility.Symbol;

public class TicTacToe implements BoardGame {

    Board board;
    Player xPlayer;
    Player oPlayer;
    Player curPlayer;
    GameContext context;

    public TicTacToe(PlayerStrategy xPlayerStrategy, PlayerStrategy oPlayerStrategy, int rows, int cols) {
        this.xPlayer = new Player(Symbol.X, xPlayerStrategy);
        this.oPlayer = new Player(Symbol.O, oPlayerStrategy);
        this.curPlayer = xPlayer;
        this.board = new Board(rows, cols);
        this.context = new GameContext();
    }


    @Override
    public void play() {
        do {
            board.printBoard();

            Position move = curPlayer.getStrategy().makeMove(board);
            board.makeMove(curPlayer, move);
            board.checkGameState(curPlayer, context);
            switchPlayer();
        } while (!context.isGameOver());

        announceResults();
    }

    public void switchPlayer() {
        curPlayer = (curPlayer == xPlayer? oPlayer : xPlayer);
    }

    @Override
    public void announceResults() {
        GameState state = context.getCurrentState();
        board.printBoard();
        if (state instanceof XWonState) {
            System.out.println("Player X wins!");
        } else if (state instanceof OWonState) {
            System.out.println("Player O wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
