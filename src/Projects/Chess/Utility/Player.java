package Projects.Chess.Utility;

public class Player {

    String name;
    boolean isWhiteSide;

    public Player(String name, boolean isWhiteSide) {
        this.name = name;
        this.isWhiteSide = isWhiteSide;
    }

    public String getName() {
        return name;
    }

    public boolean isWhiteSide() {
        return isWhiteSide;
    }
}
