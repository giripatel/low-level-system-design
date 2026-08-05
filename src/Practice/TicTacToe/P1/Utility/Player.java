package Practice.TicTacToe.P1.Utility;

import Practice.TicTacToe.P1.Strategy.PlayerStrategy;

public class Player {
    Symbol symbol;
    PlayerStrategy strategy;

    public Player(Symbol symbol, PlayerStrategy strategy) {
        this.symbol = symbol;
        this.strategy = strategy;
    }

    public PlayerStrategy getStrategy() {
        return strategy;
    }

    public Symbol getSymbol(){
        return symbol;
    }
}
