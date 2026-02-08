package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Adapter.Solution;

public class SendGridAdapter implements NotificationService {

    private SendGridNotificatinService notificatinService;

    public SendGridAdapter(SendGridNotificatinService notificatinService) {
        this.notificatinService = notificatinService;
    }

    public void send(String to, String subject, String body) {
        notificatinService.sendEmail(to, subject, body);
    }
}
