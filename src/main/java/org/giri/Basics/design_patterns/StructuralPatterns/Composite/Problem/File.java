package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Composite.Problem;

public class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("File details : " + name);
    }
}
