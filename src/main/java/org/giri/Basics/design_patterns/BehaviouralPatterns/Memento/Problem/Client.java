package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Memento.Problem;

public class Client {
    public static void main(String[] args) {
        TextEditor textEditor1 = new TextEditor();
        textEditor1.write("Hello world");
        // Problem -> undo the last write

        textEditor1.getContent();
    }
}
