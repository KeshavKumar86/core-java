package multithreading.code.deadlock.solution.practice1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Runnable2 implements Runnable {

    private final Lock lock1;
    private final Lock lock2;

    public Runnable2(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        int failureCount = 0;
        while (!tryLockingBothLocks()) {
            failureCount++;
            System.out.println(threadName +
                    " failed to lock the both locks with failure count: " + failureCount);
        }
        //do the work both lock has been acquired
        lock1.unlock();
        lock2.unlock();
    }

    private boolean tryLockingBothLocks() {
        String threadName = Thread.currentThread().getName();
        try {
            boolean isLock2Locked = lock2.tryLock(1000, TimeUnit.MILLISECONDS);
            if (!isLock2Locked) {
                return false;
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted while locking lock2");
            return false;
        }

        sleep();
        try {
            boolean isLock1Locked = lock1.tryLock(1000, TimeUnit.MILLISECONDS);
            if (!isLock1Locked) {
                lock2.unlock();
                return false;
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted while locking lock1");
            return false;
        }

        return true;
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
