package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Factory.Solution;

public class TransportService {
    public static void main(String[] args) {
        // the parameter ex: bike can be changed during runtime
        Transport transport = TransportFactory.createTransport("bike");
        transport.deliver();
    }
}
