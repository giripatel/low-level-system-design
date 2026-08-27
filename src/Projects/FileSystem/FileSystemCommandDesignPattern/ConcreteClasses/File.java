package Projects.FileSystem.FileSystemCommandDesignPattern.ConcreteClasses;

import Projects.FileSystem.FileSystemCommandDesignPattern.FileSystemNode;

public class File extends FileSystemNode {

    String content;
    String extension;

    public File(String name) {
        super(name);
        this.extension = extractExtension(name);
    }

    private String extractExtension(String name) {
        int index = name.lastIndexOf(".");
        if (index > 0) return name.substring(index + 1);
        return "";
    }

    public void setContent(String content) {
        this.content = content;
        updateModifiedDate();
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public void display(int depth) {

        String indent = " ".repeat(depth * 2);
        System.out.println(indent + " " + getName());
    }
}
