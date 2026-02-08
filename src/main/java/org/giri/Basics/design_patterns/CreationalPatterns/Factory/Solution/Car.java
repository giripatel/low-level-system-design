package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Factory.Solution;

public class Car implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivered using car");
    }
}
