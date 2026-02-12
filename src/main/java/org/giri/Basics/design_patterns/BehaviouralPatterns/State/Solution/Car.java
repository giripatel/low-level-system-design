package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.State.Solution;

public class Car implements TransportationMode{
    @Override
    public void calculateETA() {
        System.out.println("ETA for Car is 4");
    }

    @Override
    public void getDirections() {
        System.out.println("Direction for Walking: turn left in 500 meters");
    }
}
