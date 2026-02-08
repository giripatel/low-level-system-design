package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Decorator.Problem;

public class CheeseOlivePizza extends CheesePizza{
    @Override
    public String getDescription() {
        return super.getDescription() + ", Olive";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}
