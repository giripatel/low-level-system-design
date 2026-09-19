package Concurrency.ThreadCommunication.ProducerConsumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

public class ProducerConsumer {

    Queue<Integer> queue = new ArrayDeque<>();
    int CAPACITY = 5;
    public void produce() throws InterruptedException{
        int value = 0;
        while (true) {
            synchronized (this) {

                try {
                    if (queue.size() == CAPACITY) {
                        System.out.println("Buffer is full, Producer is waiting");
                        this.wait();
                    }
                    System.out.println("Produced " + value);
                    queue.offer(value ++);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                notifyAll();
            }
            Thread.sleep(1000);
        }
    }

    public void consume() throws InterruptedException{
        while (true) {
            synchronized (this) {

                try {
                    if (queue.isEmpty()) {
                        System.out.println("Buffer is empty, Consumer is waiting");
                        this.wait();
                    }
                    int value = queue.poll();
                    System.out.println("Consumed  " + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                notifyAll();
            }
            Thread.sleep(1500);
        }
    }


    public static void main(String[] args) {

        ProducerConsumer pc = new ProducerConsumer();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Producer-Thread");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Consumer Thread");

        t1.start();
        t2.start();
    }
}
