package Projects.SnakeAndFoodGame;

import Projects.SnakeAndFoodGame.Controller.GameController.SnakeGame;
import Projects.SnakeAndFoodGame.MovementStrategies.ConcreteMovementStrategies.HumanMovementStrategy;

public class Main {

    public static void main(String[] args) {

        int[][] food = {
                {0, 3},
                {1, 4},
                {2, 6},
                {5, 2},
                {6, 4},
                {8, 9},
                {9, 1}
        };

        SnakeGame snakeGame = new SnakeGame(10, 10, food, new HumanMovementStrategy());
        snakeGame.play();
    }
}
