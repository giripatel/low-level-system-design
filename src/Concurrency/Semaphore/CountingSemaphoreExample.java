package Concurrency.Semaphore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class CountingSemaphoreExample {
    private static final Semaphore resourcePool = new Semaphore(3);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.submit(()-> accessCriticalBlock());
        }
        executor.shutdown();
    }

    private static void accessCriticalBlock() {
        try {
            System.out.println(Thread.currentThread().getName() + " Trying to acquire lock ....");
            resourcePool.acquire();
            System.out.println(Thread.currentThread().getName() + " Acquired lock ....");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(Thread.currentThread().getName() + " released lock ....");
            resourcePool.release();
        }
    }
}
