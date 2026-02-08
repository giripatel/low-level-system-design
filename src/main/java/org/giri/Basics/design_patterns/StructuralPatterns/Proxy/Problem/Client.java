package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Proxy.Problem;

public class Client {
    public static void main(String[] args) {
        RealImage image = new RealImage("File1.txt");
//        RealImage image2 = new RealImage("File1.txt");

        image.displayImage();
        image.displayImage();
    }
}
