package solidPrinciple.inventoryManagementSystem.model.notificationModel;

public class EmailNotification implements Notification {
    @Override
    public void notify(String message) {
        System.out.println("[EMAIL] Notification sent: " + message);
    }
}
