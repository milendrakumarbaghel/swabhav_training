package solidPrinciple.singleResponsibilityPrinciple.q2;

public class EmailNotification implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}
