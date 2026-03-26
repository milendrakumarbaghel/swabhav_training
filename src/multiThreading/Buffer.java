package multiThreading;

class Buffer {
    private int data;
    private boolean hasValue = false;

    // Producer method
    public synchronized void produce(int value) throws InterruptedException {
        while (hasValue) {
            wait(); // wait if buffer is full
        }

        data = value;
        System.out.println("Produced: " + value);
        hasValue = true;

        notify(); // notify consumer
    }

    // Consumer method
    public synchronized int consume() throws InterruptedException {
        while (!hasValue) {
            wait(); // wait if buffer is empty
        }

        int value = data;
        System.out.println("Consumed: " + value);
        hasValue = false;

        notify(); // notify producer
        return value;
    }
}