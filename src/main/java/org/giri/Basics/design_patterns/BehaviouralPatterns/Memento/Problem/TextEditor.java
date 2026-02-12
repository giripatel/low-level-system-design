package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Memento.Problem;

public class TextEditor {
    private String contet;

    public void write(String contet) {
        this.contet = contet;
    }

    public void getContent() {
        System.out.println("Content : " + contet);
    }
}
