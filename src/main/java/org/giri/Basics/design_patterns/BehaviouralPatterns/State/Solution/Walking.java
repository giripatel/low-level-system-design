package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.State.Solution;

public class Walking implements TransportationMode{
    @Override
    public void calculateETA() {
        System.out.println("ETA for Walking is 12");
    }

    @Override
    public void getDirections() {
        System.out.println("Direction for Walking: turn left in 150 meters");
    }
}
