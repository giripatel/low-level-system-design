package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Decorator.Solution;

public class BasicPizza implements Pizza{
    @Override
    public String getDescription() {
        return "Basic Pizza";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}
