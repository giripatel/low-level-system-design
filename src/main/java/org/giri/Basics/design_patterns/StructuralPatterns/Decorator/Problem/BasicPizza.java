package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Decorator.Problem;

public class BasicPizza implements Pizza{
    public String description;
    public double cost;

    public String getDescription() {
        return "Basic Pizza";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}
