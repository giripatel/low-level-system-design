package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Adapter.Solution;

public class Client {

    public static void main(String[] args) {
        NotificationService notificationService = new SendGridAdapter(new SendGridNotificatinService());
        notificationService.send("giridhar@example.com", "Let's finish", "you can do it.....");

        // if we switch from inhouse service to SendGrid we should make a lot of changes to the Client class
    }
}
