package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Builder.Problem;

public class WithoutBuilderPattern {
    public static void main(String[] args) {
        House house = new House("Concrete", "Wood", "slab", false, true, true);
        System.out.println(house);
    }
}
