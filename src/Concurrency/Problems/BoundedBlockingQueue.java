package Concurrency.Problems;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class BoundedBlockingQueue {

    int capacity;
    Semaphore full;
    // Number of empty slots to fill
    Semaphore empty;
    ConcurrentLinkedDeque<Integer> queue;

    public BoundedBlockingQueue(int capacity) {
       full = new Semaphore(0);
       empty = new Semaphore(capacity);
       queue = new ConcurrentLinkedDeque<>();
       this.capacity = capacity;
    }

    // Method to add an element to the queue
    public void enqueue(int element) throws InterruptedException {
        System.out.println("Enqueue " + Thread.currentThread().getName() + " Size: " + queue.size() + "Element " + element);
//        if (queue.size() == capacity) {
//            System.out.println("Queue size: " + queue.size());
//            return;
//        }
        System.out.println("Enqueue " + Thread.currentThread().getName() + " Acquiring lock");
        empty.acquire();
        System.out.println("Enqueue " + Thread.currentThread().getName() + " Acquired lock");

        queue.addFirst(element);
        full.release();
    }

    // Method to remove and retrieve an element from the queue
    public int dequeue() throws InterruptedException {
        System.out.println("Dequeue " + Thread.currentThread().getName() + " Size: " + queue.size());

      int result = -1;
      if (queue.isEmpty()) {
          System.out.println("Queue is empty " + Thread.currentThread().getName());
      }
        System.out.println("Dequeue " + Thread.currentThread().getName() + " Acquiring lock");

      full.acquire();
        System.out.println("Dequeue " + Thread.currentThread().getName() + " Acquired lock");


        result = queue.pollLast();

      empty.release();
      return result;
    }

    // Method to get the current size of the queue
    public int size() throws InterruptedException {
        System.out.println("Size : " + queue.size() + " Thread " + Thread.currentThread().getName());
       return queue.size();
    }
}
