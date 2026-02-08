package main.java.org.giri.Basics.design_patterns.CreationalPatterns.AbstractFactory.Solution;

public class MacOSFactory implements UIFactory{

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new MacOSScrollBar();
    }
}
