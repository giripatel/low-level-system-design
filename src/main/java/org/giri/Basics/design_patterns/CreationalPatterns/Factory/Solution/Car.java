package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Factory.Problem;

public class Car implements Transport{
    @Override
    public void deliver() {
        System.out.println("Delivered using car");
    }
}
