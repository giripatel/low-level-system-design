package main.java.org.giri.Basics.design_patterns.CreationalPatterns.AbstractFactory.Solution;

public class WindowsButton implements Button{

    @Override
    public void render() {
        System.out.println("Rendering windows button");
    }
}
