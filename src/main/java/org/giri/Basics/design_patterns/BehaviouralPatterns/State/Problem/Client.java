package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.State.Problem;

public class Client {
    public static void main(String[] args) {
        DirectionService directionService = new DirectionService(TransportationMode.TRAIN);

        directionService.getETA();
        directionService.getDirection();
    }
}
