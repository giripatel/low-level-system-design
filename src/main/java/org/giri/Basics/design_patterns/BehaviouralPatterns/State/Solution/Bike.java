package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.State.Solution;

public class Bike implements TransportationMode{
    @Override
    public void calculateETA() {
        System.out.println("ETA for Bike is 8");
    }

    @Override
    public void getDirections() {
        System.out.println("Direction for Walking: turn left in 300 meters");
    }
}
