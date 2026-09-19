package Concurrency.Locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private int counter = 0;
    ReentrantLock lock = new ReentrantLock();

    private void increment() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired lock....");
            counter ++;
            System.out.println(Thread.currentThread().getName() + " incremented counter to " + counter);
        } finally {
            System.out.println(Thread.currentThread().getName() + " released lock....");
            lock.unlock();
        }
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> example.increment());
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Final counter value: " + example.getCounter());
            } else {
                System.out.println("Timeout: Not all tasks finished");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
