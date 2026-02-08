package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Decorator.Solution;

public class PizzaApp {
    public static void main(String[] args) {
        Pizza pizza = new BasicPizza();

        pizza = new CheeseDecorator(pizza);
        pizza = new OliveDecorator(pizza);
        pizza = new MushroomDecorator(pizza);

        System.out.println(pizza.getCost());
        System.out.println(pizza.getDescription());
    }
}
