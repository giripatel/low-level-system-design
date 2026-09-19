package Concurrency.Problems;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;

    Semaphore numberSemaPhore = new Semaphore(1);
    Semaphore fizzSemaPhore = new Semaphore(0);
    Semaphore buzzSemaPhore = new Semaphore(0);
    Semaphore fizzbuzzSemaPhore = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i = 1; i <= n; i ++) {
            if(i % 3 == 0 && i % 5 != 0) {
                fizzSemaPhore.acquire();
                printFizz.run();
                numberSemaPhore.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i = 1; i <= n; i ++) {
            if(i % 3 != 0 && i % 5 == 0) {
                buzzSemaPhore.acquire();
                printBuzz.run();
                numberSemaPhore.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i = 1; i <= n; i ++) {
            if(i % 3 == 0 && i % 5 == 0) {
                fizzbuzzSemaPhore.acquire();
                printFizzBuzz.run();
                numberSemaPhore.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {

        for(int i = 1; i <= n; i ++) {
            numberSemaPhore.acquire();
            if(i % 3 == 0 && i % 5 == 0) {
                fizzbuzzSemaPhore.release();
            } else if(i % 3 == 0) {
                fizzSemaPhore.release();
            } else if(i % 5 == 0) {
                buzzSemaPhore.release();
            } else {
                printNumber.accept(i);
                numberSemaPhore.release();
            }
        }
    }
}
