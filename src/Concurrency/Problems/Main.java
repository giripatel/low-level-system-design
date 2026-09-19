package Concurrency.Problems;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BoundedBlockingQueue boundedBlockingQueue = new BoundedBlockingQueue(3);
        ExecutorService producerService = Executors.newFixedThreadPool(3);
        ExecutorService consumerService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            int x = i + 1;
            producerService.submit(()-> {
                try {
                    boundedBlockingQueue.enqueue(x);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            consumerService.submit(() -> boundedBlockingQueue.dequeue());
        }

//            producerService.submit(()-> {
//                    try {
//                        boundedBlockingQueue.enqueue(1);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                });
//            Thread.sleep(500);
//        producerService.submit(()-> {
//        try {
//            boundedBlockingQueue.enqueue(1);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        });
//        Thread.sleep(500);
//        producerService.submit(()-> {
//            try {
//                boundedBlockingQueue.enqueue(2);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        producerService.submit(()-> {
//            try {
//                boundedBlockingQueue.enqueue(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        Thread.sleep(500);
//        consumerService.submit(() -> boundedBlockingQueue.dequeue());
//        Thread.sleep(500);
//        consumerService.submit(() -> boundedBlockingQueue.dequeue());
//        Thread.sleep(500);
//        consumerService.submit(() -> boundedBlockingQueue.dequeue());
//        Thread.sleep(500);
//        producerService.submit(()-> {
//            try {
//                boundedBlockingQueue.enqueue(3);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });

        producerService.shutdown();
        consumerService.shutdown();
    }
}
