package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Composite.Solution;

import java.util.ArrayList;
import java.util.List;

public class Folder  implements FileSystemComponent{
    private String name;
    // Folder can also contain folders in it along with files,
    // but it is not possible to store both of them in a single List.
    // This builds tight coupling
    private List<FileSystemComponent> fileSystemComponents= new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent fileSystemComponent) {
        fileSystemComponents.add(fileSystemComponent);
    }

    public void showDetails() {
        System.out.println("Folder details : " + name);
        for (FileSystemComponent fileSystemComponent: fileSystemComponents) {
            fileSystemComponent.showDetails();
        }
    }
}
