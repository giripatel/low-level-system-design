package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.State.Solution;

public class Train implements TransportationMode{
    @Override
    public void calculateETA() {
        System.out.println("ETA for Train is 7");
    }

    @Override
    public void getDirections() {
        System.out.println("Direction for Trian: go straight 9 km");
    }
}
