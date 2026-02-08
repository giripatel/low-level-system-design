package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Factory.Solution;

public class TransportFactory {

    public static Transport createTransport(String type) {
        switch (type.toLowerCase()) {
            case "bike":
                return new Bike();
            case "car":
                return new Car();
            case "bus":
                return new Bus();
            default:
                throw new IllegalArgumentException("Unsupported type");
        }
    }
}
