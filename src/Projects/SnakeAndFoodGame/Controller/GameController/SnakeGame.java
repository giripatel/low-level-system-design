package Projects.SnakeAndFoodGame.Controller.GameController;

import Projects.SnakeAndFoodGame.Controller.BoardGame;
import Projects.SnakeAndFoodGame.MovementStrategies.MovementStrategy;
import Projects.SnakeAndFoodGame.UtilityClasses.GameBoard;
import Projects.SnakeAndFoodGame.UtilityClasses.Pair;
import Projects.SnakeAndFoodGame.UtilityClasses.Snake;

import java.util.*;

public class SnakeGame implements BoardGame {

    GameBoard gameBoard;
    Deque<Pair> snake;
    Map<Pair, Boolean> positionMap;
//    Snake snake;
    int[][] food;
    int foodIndex;
    MovementStrategy movementStrategy;

    public SnakeGame(int width, int height, int[][] food, MovementStrategy movementStrategy) {
        this.gameBoard = GameBoard.getInstance(width, height);
        this.food = food;
        this.movementStrategy = movementStrategy;

        Pair initialPos = new Pair(0, 0);
        this.snake = new LinkedList<>();
        this.positionMap = new HashMap<>();

        snake.offerFirst(initialPos);
        positionMap.put(initialPos, true);
    }

    public int move(String direction) {
        // Get current head
        Pair currentHead = this.snake.peekFirst();

        // Get next position using direction
        Pair newHead = movementStrategy.getNextPosition(currentHead, direction);
        int newHeadRow = newHead.getRow();
        int newHeadCol = newHead.getCol();

        // Check boundary conditions
        boolean isCrossingBoundary = newHeadRow < 0 || newHeadRow >= this.gameBoard.getHeight() || newHeadCol < 0 || newHeadCol >= this.gameBoard.getWidth();

        Pair currentTail = this.snake.peekLast();

        boolean biteItself = this.positionMap.containsKey(newHead) && !(newHead.getCol() == currentTail.getCol() && newHead.getRow() == currentTail.getRow());

        if(isCrossingBoundary || biteItself) {
            return -1;
        }

        boolean ateFood = (this.foodIndex < this.food.length) &&
                (this.food[this.foodIndex][0] == newHeadRow) && (this.food[this.foodIndex][1] == newHeadCol);

        if (ateFood) {
            // increment foodIndex to move next
            this.foodIndex ++;
        } else {
            // If no food eaten, remove tail
            this.snake.pollLast();
            this.positionMap.remove(currentTail);
        }

        // Add new head
        this.snake.offerFirst(newHead);
        this.positionMap.put(newHead, true);

        // Calculate ans return score
        int score = this.snake.size() - 1;
        return score;
    }

    private void displayGame() {
        System.out.println("Current snake length: " + snake.size());
    }

    private String converIntput(String input) {
        switch (input) {
            case "W" -> {
                return  "U";
            }
            case "S" -> {
                return "D";
            }
            case "A" -> {
                return "L";
            }
            case "D" -> {
                return "R";
            }
            default -> {
                return "";
            }
        }
    }
    /**
     *
     */
    @Override
    public void play() {
        System.out.println("====== SNAKE GAME ======");
        System.out.println("Controls: W (Up), S (Down), A (Left), D (Right), Q (Quit)");
        System.out.println("Eat food to grow your snake and increase your score.");
        System.out.println("Don't hit the walls or bite yourself!");
        System.out.println("========================");

        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;
        int score = 0;

        while (gameRunning) {

            displayGame();

            System.out.print("Enter move (W/S/A/D) or Q to quit: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("Q")) {
                System.out.println("Game ended by player. Final score: " + score);
                gameRunning = false;
                continue;
            }

            String direction = converIntput(input);

            if (direction.isEmpty()) {
                System.out.println("Invalid input! User W/A/S/D to move or Q to quit");
                continue;
            }

            score = move(direction);

            if(score == -1) {
                System.out.println("GAME OVER! You hit a wall or bit yourself.");
                System.out.println("Final score: " + score);
                gameRunning = false;
            } else {
                System.out.println("Score: " + score);
            }
        }
        scanner.close();
        System.out.println("Thanks for playing!");
    }

    public Deque<Pair> getSnake() {
        return snake;
    }
}
