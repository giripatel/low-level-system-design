package main.java.org.giri.Basics.design_patterns.StructuralPatterns.FlyWeight.Problem;

public class Game {
    public static void main(String[] args) {

        for(int i = 0; i < 5; i ++) {
            Bullet bullet = new Bullet("Red", i * 10, i * 12, 5);
        }

        for(int i = 0; i < 5; i ++) {
            Bullet bullet = new Bullet("Blue", i * 10, i * 12, 5);
        }

        // Problems
        // Memory Overhead : Every bullet stores redundant data like color, image
        // Performance : Slow performance when many bullets are created
    }
}
