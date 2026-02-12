package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.State.Problem;

public class DirectionService {

    TransportationMode transportationMode;

    public DirectionService(TransportationMode transportationMode) {
        this.transportationMode = transportationMode;
    }

    public void setTransportionMode(TransportationMode transportationMode) {
        this.transportationMode = transportationMode;
    }

    public void getETA() {
        switch (transportationMode) {
            case WALKING -> System.out.println("ETA for Walking is 15");
            case CYCLING -> System.out.println("ETA for cycling is 10");
            case BIKE -> System.out.println("ETA for bike is 8");
            case TRAIN -> System.out.println("ETA for train is 5");
        }
    }

    public void getDirection() {
        switch (transportationMode) {
            case WALKING -> System.out.println("Direction for Walking: turn left in 150 meters");
            case CYCLING -> System.out.println("Direction for cycling: go straight till 2 kms");
            case BIKE -> System.out.println("Direction for bike: take right after 200 meters");
            case TRAIN -> System.out.println("Direction for train: go straight till 9 kms");
        }
    }
}
