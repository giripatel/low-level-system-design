package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Observer.Solution;

public class Main {
    public static void main(String[] args) {
        Observer obs1 = new DisplayDevice("iPad");
        Observer obs2 = new MobileDevice("Pixel");

        WeatherStation weatherStation = new WeatherStation();

        weatherStation.attach(obs1);
        weatherStation.attach(obs2);

        weatherStation.setTemperature(11.3);
        weatherStation.setTemperature(13.9);
    }
}
