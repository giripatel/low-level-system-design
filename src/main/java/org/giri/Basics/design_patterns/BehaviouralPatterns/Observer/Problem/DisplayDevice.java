package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Observer.Problem;


// DisplayDevice can be anything ex: laptop, TV
public class DisplayDevice {
    private String name;

    public DisplayDevice(String name) {
        this.name = name;
    }

    public void showTemp(double temperature) {
        System.out.println(name + " Temperature : " + temperature + " C");
    }
}
