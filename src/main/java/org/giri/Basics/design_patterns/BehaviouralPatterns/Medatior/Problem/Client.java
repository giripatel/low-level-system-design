package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Medatior.Problem;

public class Client {
    public static void main(String[] args) {
        User user = new User("Giri");
        User user1 = new User("Vishnu");

        user.sendMessage(user1, "Hey buddy....!");
    }
}
