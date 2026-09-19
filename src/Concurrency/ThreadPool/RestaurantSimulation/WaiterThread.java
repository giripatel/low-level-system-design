package Concurrency.ThreadPool.RestaurantSimulation;

public class WaiterThread extends Thread{

    Object lock;

    public WaiterThread(Object lock) {
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            try {
                System.out.println("Waiting for the food to be ready...");
                lock.wait();
                System.out.println("Food is ready! Delivering to the customer");
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }
}
