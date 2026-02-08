package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Proxy.Solution;

import java.util.HashMap;
import java.util.Map;

public class ProxyImage implements Image {
    private  String filename;
    private RealImage realImage;
    private Map<String, RealImage> cache = new HashMap<>();

    public ProxyImage(String filename) {
            this.filename = filename;
    }

    @Override
    public void displayImage() {
        if(realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.displayImage();
    }
}
