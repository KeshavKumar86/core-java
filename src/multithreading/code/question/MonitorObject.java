package multithreading.code.question;

public class MonitorObject {

    private int count;

    public void doWait() {
        synchronized (this) {
            try {
                count++;
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void doNotify() {
        synchronized (this) {
            if (count > 0) {
                notify();
                count--;
            }

        }
    }
}
