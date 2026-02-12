package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.State.Solution;

public class Client {
    public static void main(String[] args) {
        DirectionService directionService = new DirectionService(new Car());;

        directionService.getETA();
        directionService.getDirections();
    }
}
