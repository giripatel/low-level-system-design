package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Observer.Problem;

import java.util.List;

public class WeatherStation {
    private double temperature;
    private MobileDevice mobileDevice;
    private DisplayDevice displayDevice;

    public WeatherStation(DisplayDevice displayDevice, MobileDevice mobileDevice){
        this.displayDevice = displayDevice;
        this.mobileDevice = mobileDevice;
    }

    public void notifyTemperature(double temperature) {
        displayDevice.showTemp(temperature);
        mobileDevice.showTemp(temperature);
    }
}
