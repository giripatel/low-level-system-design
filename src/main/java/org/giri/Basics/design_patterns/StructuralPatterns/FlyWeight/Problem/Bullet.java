package main.java.org.giri.Basics.design_patterns.StructuralPatterns.FlyWeight.Problem;

public class Bullet {
    private String color;   // Intrinsic property shared by all bullet
    private int x, y;       // Extrinsic property unique to each bullet
    private int velocity;

    public Bullet(String color, int x, int y, int velocity) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        System.out.println("Creating bullet at (" + x + ", " + y + ") with velocity " + velocity);
    }

    public void display() {
        System.out.println("Bullet at (" + x + ", " + y + ") moving at velocity " + velocity);
    }
}
