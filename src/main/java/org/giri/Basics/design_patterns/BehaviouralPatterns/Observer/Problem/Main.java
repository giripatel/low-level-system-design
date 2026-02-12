package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Observer.Problem;

public class Main {
    public static void main(String[] args) {
        DisplayDevice displayDevice = new DisplayDevice("iPad");
        MobileDevice mobileDevice = new MobileDevice("Pixel 9");

        WeatherStation weatherStation = new WeatherStation(displayDevice, mobileDevice);

        // Problem -> Tight coupling between WeatherStation and DisplayDevices
        weatherStation.notifyTemperature(8.2);
        weatherStation.notifyTemperature(7.3);
    }
}
