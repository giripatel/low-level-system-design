package Concurrency.ThreadPool.RestaurantSimulation;

public class RestaurantSimulation {
    public static void main(String[] args) {
        Object lock = new Object();
        ChefThread chefThread = new ChefThread(lock);
        WaiterThread waiterThread = new WaiterThread(lock);

        waiterThread.start();
        chefThread.start();
    }
}
