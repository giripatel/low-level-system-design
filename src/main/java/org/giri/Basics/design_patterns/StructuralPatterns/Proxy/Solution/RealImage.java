package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Proxy.Solution;

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loaded image : " + filename);
    }

    @Override
    public void displayImage() {
        System.out.println("Displaying image : " + filename);
    }
}
