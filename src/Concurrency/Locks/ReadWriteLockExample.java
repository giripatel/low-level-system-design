package Concurrency.Locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int logValue = 0;

    private void simulateWork() {
        long sum = 0;
        for (int i = 0; i < 500000; i++) {
            sum += i;
        }
    }

    private void write(String taskName, int newValue) {
        lock.writeLock().lock();
        try {
            System.out.println(taskName + " (write) acquired lock..");
            simulateWork();
            this.logValue = newValue;
            System.out.println(taskName + " (write): Updated logValue to " + logValue);
        } finally {
            System.out.println(taskName + " (write): Released write lock.");
            lock.writeLock().unlock();
        }
    }

    private void readValue(String taskName) {
        lock.readLock().lock();
        try {
            System.out.println(taskName + " (read): acquired lock");
            simulateWork();
            System.out.println(taskName + " (read): Finished reading.");
        } finally {
            System.out.println(taskName + " (read): Released read lock. ");
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample rwdLockExample = new ReadWriteLockExample();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(() -> rwdLockExample.readValue("Reader-1"));
        executor.submit(() ->rwdLockExample.readValue("Reader-2"));

        executor.submit(() ->rwdLockExample.write("Writer-1", 100));

        executor.submit(() ->rwdLockExample.readValue("Reader-3"));
        executor.submit(() ->rwdLockExample.readValue("Reader-4"));

        executor.submit(() ->rwdLockExample.write("Writer-2", 200));

        executor.submit(() ->rwdLockExample.readValue("Reader-5"));
        executor.submit(() ->rwdLockExample.readValue("Reader-6"));

        executor.shutdown();
    }
}
