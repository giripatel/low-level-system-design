package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Observer.Solution;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
