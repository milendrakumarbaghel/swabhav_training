package solidPrinciple.singleResponsibilityPrinciple.q3;

public class SMSAlertService implements AlertService {
    public void sendAlert(String message) {
        System.out.println("SMS Alert: " + message);
    }
}
