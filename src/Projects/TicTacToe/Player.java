package Projects.TicTacToe;

public class Player {

    private Symbol symbol;
    private PlayerStrategy strategy;

    public Player(Symbol symbol, PlayerStrategy strategy) {
        this.symbol = symbol;
        this.strategy = strategy;
    }

//    public Position makeMove(Board board) {
//
//    }

    public Symbol getSymbol(){
        return symbol;
    }

    public PlayerStrategy getStrategy() {
        return strategy;
    }
}
