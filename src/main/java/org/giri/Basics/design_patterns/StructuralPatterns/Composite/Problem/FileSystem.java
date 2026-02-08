package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Composite.Problem;

public class FileSystem {
    public static void main(String[] args) {
        File file1 = new File("cat.png");
        File file2 = new File("dog.png");
        Folder folder = new Folder("Animals");

        folder.addFile(file1);
        folder.addFile(file2);

        folder.showDetails();
        file2.showDetails();
    }
}
