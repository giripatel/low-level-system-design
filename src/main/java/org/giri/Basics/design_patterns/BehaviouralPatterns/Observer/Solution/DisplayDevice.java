package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Observer.Solution;

// DisplayDevice can be anything ex: laptop, TV
public class DisplayDevice implements Observer{
    private String name;

    public DisplayDevice(String name) {
        this.name = name;
    }

    public void update(double temperature) {
        System.out.println(name + " Temperature : " + temperature + " C");
    }
}
