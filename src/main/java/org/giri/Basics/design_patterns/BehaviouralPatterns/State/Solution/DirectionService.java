package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.State.Solution;

public class DirectionService {
    TransportationMode transportationMode;

    public DirectionService(TransportationMode transportationMode) {
        this.transportationMode = transportationMode;
    }

    public void setTransportationMode(TransportationMode transportationMode) {
        this.transportationMode = transportationMode;
    }

    public void getETA() {
        transportationMode.calculateETA();
    }

    public void getDirections() {
        transportationMode.getDirections();
    }
}
