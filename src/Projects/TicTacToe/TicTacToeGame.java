package Projects.TicTacToe;

public class TicTacToeGame implements BoardGame{
    private Board board;
    private Player playerX;
    private Player playerY;
    private Player currentPlayer;
    private GameContext gameContext;

    public TicTacToeGame(PlayerStrategy xPlayerStrategy, PlayerStrategy oPlayerStrategy, int rows, int columns) {
        this.board = new Board(rows, columns);
        this.playerX = xPlayerStrategy;
        this.playerY = ;
        this.gameContext = new GameContext();
    }

    @Override
    public void play() {

    }

    @Override
    public void switchPlayers() {

    }

    @Override
    public void announceResults() {

    }
}
