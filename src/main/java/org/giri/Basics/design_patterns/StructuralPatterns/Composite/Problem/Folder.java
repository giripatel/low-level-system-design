package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Composite.Problem;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    // Folder can also contain folders in it along with files,
    // but it is not possible to store both of them in a single List.
    // This builds tight coupling
    private List<File> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void showDetails() {
        System.out.println("Folder details : " + name);
        for (File file: files) {
            file.showDetails();
        }
    }
}
