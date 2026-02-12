package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Observer.Solution;


public class MobileDevice implements Observer{
    private String name;

    public MobileDevice(String name) {
        this.name = name;
    }

    public void update(double temperature) {
        System.out.println(name + " Temperature : " + temperature + " C");
    }
}
