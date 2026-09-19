package Concurrency.Problems;

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {

    private Semaphore semaphore;
    private Semaphore[] forkSemaphore;

    public DiningPhilosophers() {
        semaphore = new Semaphore(4);

        forkSemaphore = new Semaphore[5];

        for(int i = 0; i < 5; i ++) {
            forkSemaphore[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        semaphore.acquire();

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        Semaphore leftSemaphore = forkSemaphore[left];
        Semaphore rightSemaphore = forkSemaphore[right];

        leftSemaphore.acquire();
        rightSemaphore.acquire();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        leftSemaphore.release();
        putRightFork.run();
        rightSemaphore.release();

        semaphore.release();
    }
}
