package Concurrency.Semaphore;

import java.util.concurrent.Semaphore;

public class BinarySemaphore {
    private static final Semaphore mutex = new Semaphore(1);

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> accessCriticalSection(), "Thread one");
        Thread t2 = new Thread(() -> accessCriticalSection(), "Thread two");
        t1.start();
        t2.start();
    }
    public static void accessCriticalSection() {
        try {
            System.out.println(Thread.currentThread().getName() + " Attempting to acquire lock");
            mutex.acquire();
            System.out.println(Thread.currentThread().getName() + " Acquired lock");

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(Thread.currentThread().getName() + " Released lock");
            mutex.release();
        }
    }
}
