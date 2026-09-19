package Concurrency.ThreadCreation.RunnableInterface;

public class MyRunnable implements Runnable{
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("Thread " + Thread.currentThread().getName() + " running " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
