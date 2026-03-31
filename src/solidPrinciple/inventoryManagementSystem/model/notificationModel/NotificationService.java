package solidPrinciple.inventoryManagementSystem.model.notificationModel;

import java.util.List;

public class NotificationService {
    private List<Notification> notifications;

    public NotificationService(List<Notification> notifications){
        this.notifications = notifications;
    }

    public void send(String message) {
        for(Notification notification : notifications) {
            notification.notify(message);
        }
    }
}
