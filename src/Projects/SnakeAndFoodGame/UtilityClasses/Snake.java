package Projects.SnakeAndFoodGame.UtilityClasses;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Snake {

    private Deque<Pair> body;
    private Map<Pair, Boolean> positionMap;

    public Snake() {
        this.body = new LinkedList<>();
        this.positionMap = new HashMap<>();
        // Initialize snake at position [0, 0]
        Pair initialPos = new Pair(0, 0);
        body.offerFirst(initialPos);
        positionMap.put(initialPos, true);
    }

    public Deque<Pair> getBody() {
        return body;
    }

    public Map<Pair, Boolean> getPositionMap() {
        return positionMap;
    }
}
