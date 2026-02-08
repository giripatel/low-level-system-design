package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Composite.Solution;

public class File implements FileSystemComponent{
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("File details : " + name);
    }
}
