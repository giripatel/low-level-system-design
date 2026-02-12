package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Observer.Problem;

public class MobileDevice {
    private String name;

    public MobileDevice(String name) {
        this.name = name;
    }

    public void showTemp(double temperature) {
        System.out.println(name + " Temperature : " + temperature + " C");
    }
}
