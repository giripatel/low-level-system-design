package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Memento.Solution;

import javax.swing.tree.DefaultTreeCellEditor;

public class TextEditor {
    private String contet;

    public void write(String contet) {
        this.contet = contet;
    }

    public EditorMemento save() {
        return new EditorMemento(contet);
    }

    public void restore(EditorMemento editorMemento) {
        this.contet = editorMemento.getContet();
    }
    public String getContent() {
        return contet;
    }
}