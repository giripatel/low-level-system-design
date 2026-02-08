package main.java.org.giri.Basics.design_patterns.CreationalPatterns.AbstractFactory.Solution;

public class WindowsFactory implements UIFactory{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new WindowsScrollBar();
    }
}
