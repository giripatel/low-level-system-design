package main.java.org.giri.Basics.design_patterns.CreationalPatterns.AbstractFactory.Solution;

public class MacOSScrollBar implements ScrollBar{
    @Override
    public void scroll() {
        System.out.println("Scrolling MacOS scroll");
    }
}
