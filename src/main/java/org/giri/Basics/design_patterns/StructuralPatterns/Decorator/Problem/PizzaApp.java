package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Decorator.Problem;

public class PizzaApp {
    public static void main(String[] args) {
        Pizza basicPizza = new BasicPizza();
        Pizza cheesPizza = new CheesePizza();
        Pizza cheesMushroomPizza = new CheeseMushroomPizza();
        Pizza cheeseOlivePizza = new CheeseOlivePizza();
        System.out.println(basicPizza.getDescription() + " " + basicPizza.getCost());
        System.out.println(cheesPizza.getDescription() + " " + cheesPizza.getCost());
        System.out.println(cheesMushroomPizza.getDescription() + " " + cheesMushroomPizza.getCost());
        System.out.println(cheeseOlivePizza.getDescription() + " " + cheeseOlivePizza.getCost());
    }
}
