package com.powernode.leetcode.fizzbuzzmultithreaded;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Author: 19599
 * @Date: 2025/5/15 8:25
 * @Description:
 */
public class FizzBuzz1 {
    private final int n;
    private volatile int cur;

    private final Semaphore numberSem = new Semaphore(1);
    private final Semaphore fizzSem = new Semaphore(0);
    private final Semaphore buzzSem = new Semaphore(0);
    private final Semaphore fizzbuzzSem = new Semaphore(0);

    FizzBuzz1(int n) {
        this.n = n;
        cur = 1;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            fizzSem.acquire();
            if (cur > n) {
                break;
            }
            printFizz.run();
            numberSem.release();
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            buzzSem.acquire();
            if (cur > n) {
                break;
            }
            printBuzz.run();
            numberSem.release();
        }
    }

    public void fizzbuzz(Runnable printFizzbuzz) throws InterruptedException {
        while (true) {
            fizzbuzzSem.acquire();
            if (cur > n) {
                break;
            }
            printFizzbuzz.run();
            numberSem.release();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (cur <= n) {
            numberSem.acquire();
            if (cur % 15 == 0) {
                fizzbuzzSem.release();
            } else if (cur % 3 == 0) {
                fizzSem.release();
            } else if (cur % 5 == 0) {
                buzzSem.release();
            } else {
                printNumber.accept(cur);
                numberSem.release();
            }
            cur++;
        }

        fizzSem.release();
        fizzbuzzSem.release();
        buzzSem.release();
    }
}
