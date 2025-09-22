package com.powernode.leetcode.printinorder;

import java.util.concurrent.Semaphore;

/**
 * @Author: 19599
 * @Date: 2025/5/15 8:04
 * @Description:
 */
public class Foo1 {
    private final Semaphore first = new Semaphore(1);
    private final Semaphore second = new Semaphore(0);
    private final Semaphore third = new Semaphore(0);

    private int n;

    Foo1(int n) {
        this.n = n;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            first.acquire();
            printFirst.run();
            second.release();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            second.acquire();
            printSecond.run();
            third.release();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            third.acquire();
            printThird.run();
            first.release();
        }
    }


}
