package com.powernode.leetcode.printinorder;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 19599
 * @Date: 2025/5/14 21:19
 * @Description:
 */
public class Foo {
    private final Lock lock;
    private final Condition conditionFirst;
    private final Condition conditionSecond;
    private final Condition conditionThird;

    private int n;
    private int state;

    Foo(int n) {
        lock = new ReentrantLock();
        conditionFirst = lock.newCondition();
        conditionSecond = lock.newCondition();
        conditionThird = lock.newCondition();
        this.n = n;
        state = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (state != 1) {
                    conditionFirst.await();
                }
                printFirst.run();
                state = 2;
                conditionSecond.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (state != 2) {
                    conditionSecond.await();
                }
                printSecond.run();
                state = 3;
                conditionThird.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (state != 3) {
                    conditionThird.await();
                }
                printThird.run();
                state = 1;
                conditionFirst.signal();
            } finally {
                lock.unlock();
            }
        }
    }

}