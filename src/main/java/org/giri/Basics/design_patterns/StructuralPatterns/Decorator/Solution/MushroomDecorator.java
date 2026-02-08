package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Decorator.Solution;

public class MushroomDecorator extends PizzaDecorator{

    public MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Mushroom";
    }

    @Override
    public double getCost() {
        return super.getCost() + 3.0;
    }
}
