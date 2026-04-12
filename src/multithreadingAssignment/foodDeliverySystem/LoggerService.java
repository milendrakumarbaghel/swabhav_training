package multithreadingAssignment.foodDeliverySystem;

public class LoggerService extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Logger: System running smoothly...");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
