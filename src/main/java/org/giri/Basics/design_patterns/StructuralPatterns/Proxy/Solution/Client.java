package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Proxy.Solution;

public class Client {
    public static void main(String[] args) {
        Image image = new ProxyImage("File1.txt");
        Image image2 = new ProxyImage("File1.txt");

        image.displayImage();
        image2.displayImage();
    }
}
