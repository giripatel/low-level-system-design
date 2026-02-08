package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Adapter.Solution;

public class SendGridNotificatinService {

    public void sendEmail(String to, String subject, String body) {
        System.out.println("From send grid");
        System.out.println("to : " + to);
        System.out.println("subject : " + subject);
        System.out.println("body : " + body);
    }
}
