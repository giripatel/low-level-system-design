package Projects.TicTacToe.Controller.GameController;

import Projects.TicTacToe.CommonEnum.Symbol;
import Projects.TicTacToe.Controller.BoardGame;
import Projects.TicTacToe.GameStateHandler.ConcreteState.GameState;
import Projects.TicTacToe.GameStateHandler.ConcreteState.OWonState;
import Projects.TicTacToe.GameStateHandler.ConcreteState.XWonState;
import Projects.TicTacToe.GameStateHandler.Context.GameContext;
import Projects.TicTacToe.PlayerStrategies.PlayerStrategy;
import Projects.TicTacToe.Utility.Board;
import Projects.TicTacToe.Utility.Player;
import Projects.TicTacToe.Utility.Position;

public class TicTacToeGame implements BoardGame {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private GameContext gameContext;

    public TicTacToeGame(PlayerStrategy xPlayerStrategy, PlayerStrategy oPlayerStrategy, int rows, int columns) {
        this.board = new Board(rows, columns);
        this.playerX = new Player(Symbol.X, xPlayerStrategy);
        this.playerO = new Player(Symbol.O, oPlayerStrategy);
        this.currentPlayer = playerX;
        this.gameContext = new GameContext();
    }

    @Override
    public void play() {
        do {
            board.printBoard();

            Position move = currentPlayer.getStrategy().makeMove(board);
            board.makeMove(move, currentPlayer.getSymbol());
            board.checkGameState(gameContext, currentPlayer);
            switchPlayers();
        } while (!gameContext.isGameOver());
        announceResults();
    }

    @Override
    public void switchPlayers() {
        currentPlayer = (currentPlayer == playerX)? playerO : playerX;
    }

    @Override
    public void announceResults() {
        GameState state = gameContext.getCurrState();
        board.printBoard();
        if (state instanceof XWonState) {
            System.out.println("Player X wins..!");
        } else if (state instanceof OWonState) {
            System.out.println("Player O wins..!");
        } else {
            System.out.println("It's a draw");
        }
    }
}
