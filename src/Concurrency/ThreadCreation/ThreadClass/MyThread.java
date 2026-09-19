package Concurrency.ThreadCreation.ThreadClass;
import java.lang.Thread;

public class MyThread extends Thread{
    public void run() {
        for (int i = 0; i < 5; i ++) {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}
