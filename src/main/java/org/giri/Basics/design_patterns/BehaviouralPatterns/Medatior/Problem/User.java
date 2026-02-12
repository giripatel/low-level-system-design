package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Medatior.Problem;

public class User {
    public String name;

    public User(String name) {
        this.name = name;
    }
    public void sendMessage(User user, String message){
        System.out.println(name  + " : sent message " + message+" to: " + user.name);
    }
}
