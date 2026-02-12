package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Memento.Solution;

public class Client {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        editor.write("Hello world...!");
        caretaker.saveState(editor);
        editor.write("Hey folks....!");
        caretaker.saveState(editor);
        // Undo the changes
        caretaker.undo(editor);

        System.out.println(editor.getContent());
    }
}
