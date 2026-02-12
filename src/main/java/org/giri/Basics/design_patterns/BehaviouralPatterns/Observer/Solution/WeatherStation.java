package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Observer.Solution;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{

    private double temperature;
    private List<Observer> observersList;

    public WeatherStation() {
        this.observersList = new ArrayList<>();
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
    @Override
    public void attach(Observer observer) {
        observersList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs: observersList) {
            obs.update(temperature);
        }
    }
}
