package Concurrency.ThreadPool.RestaurantSimulation;

public class ChefThread extends Thread {

    Object lock;

    public ChefThread(Object lock) {
        this.lock = lock;
    }

    public void run() {
        try {
            Thread.sleep(5000);
            synchronized (lock) {
                System.out.println("Food is ready notifying the waiter ........");
                lock.notify();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
