package Concurrency.ThreadCreation.RunnableInterface;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable r1 = new MyRunnable();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

        t1.start();
        t2.start();

        System.out.println("Main Thread : " + Thread.currentThread().getName());

        t1.interrupt();
        t2.interrupt();
//        Thread.sleep(1000);
        System.out.println("Main after sleep");
    }
}
