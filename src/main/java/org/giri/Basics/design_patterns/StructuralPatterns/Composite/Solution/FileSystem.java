package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Composite.Solution;

public class FileSystem {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("cat.png");
        FileSystemComponent file2 = new File("dog.png");
        Folder folder = new Folder("Animals");

        folder.addComponent(file1);
        folder.addComponent(file2);

        Folder subFolder = new Folder("subfolder");
        FileSystemComponent file3 = new File("horse.png");
        FileSystemComponent file4 = new File("lion.png");

        subFolder.addComponent(file3);
        subFolder.addComponent(file4);
        folder.addComponent(subFolder);

        folder.showDetails();
//        file2.showDetails();
    }
}
