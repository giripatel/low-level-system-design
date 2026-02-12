package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Memento.Solution;

import java.util.HashSet;
import java.util.Stack;

public class Caretaker {
    private Stack<EditorMemento> history = new Stack<>();

    public void saveState(TextEditor editor) {
        history.push(editor.save());
    }

    public void undo(TextEditor textEditor) {
        if(!history.isEmpty()) {
            history.pop();
            textEditor.restore(history.peek());
        }
    }
}
