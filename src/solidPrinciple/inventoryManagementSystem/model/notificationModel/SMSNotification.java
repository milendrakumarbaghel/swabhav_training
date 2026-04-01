package solidPrinciple.inventoryManagementSystem.model.notificationModel;

public class SMSNotification implements Notification {
    @Override
    public void notify(String message) {
        System.out.println("[SMS] Notification sent: " + message);
    }
}
