package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Factory.Problem;

public class TransportService {
    // Tightly coupled
    public void transport() {
        // Direct object creation
        Transport car = new Car();
        Transport bike = new Bike();
        // if we need to add a new transport it creations problem because we are creating
        // objects manually
        Transport bus = new Bus();
    }
}
