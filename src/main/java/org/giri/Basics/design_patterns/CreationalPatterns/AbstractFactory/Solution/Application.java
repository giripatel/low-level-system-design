package main.java.org.giri.Basics.design_patterns.CreationalPatterns.AbstractFactory.Solution;

public class Application {
    private Button button;
    private ScrollBar scrollBar;

    public Application(UIFactory factory){
        this.button = factory.createButton();
        this.scrollBar = factory.createScrollBar();
    }

    public void renderUI() {
        button.render();
        scrollBar.scroll();
    }

    public static void main(String[] args) {
        UIFactory uiFactory = new WindowsFactory();
        Application app = new Application(uiFactory);
        app.renderUI();
    }
}
