package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Adapter.Solution;

public class EmailNotificationService implements NotificationService {

    public void send(String to, String subject, String body) {
        System.out.println("to : " + to);
        System.out.println("subject : " + subject);
        System.out.println("body : " + body);
    }
}
