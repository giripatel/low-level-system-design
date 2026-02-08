package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Decorator.Solution;

abstract class PizzaDecorator implements Pizza{

    Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}
