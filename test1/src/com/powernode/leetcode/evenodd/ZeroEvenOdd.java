package com.powernode.leetcode.evenodd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Author: 19599
 * @Date: 2025/5/21 4:23
 * @Description:
 */
public class ZeroEvenOdd {
    private int n;
    private final Lock lock = new ReentrantLock();
    private final Condition zeroCondition = lock.newCondition();
    private final Condition evenCondition = lock.newCondition();
    private final Condition oddCondition = lock.newCondition();
    private int turn = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(Runnable printZero) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                while (turn != 0) {
                    zeroCondition.await();
                }
                printZero.run();
                if (i % 2 == 1) {
                    turn = 1;
                    oddCondition.signal();
                } else {
                    turn = 2;
                    evenCondition.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printEven) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            lock.lock();
            try {
                while (turn != 2) {
                    evenCondition.await();
                }
                printEven.accept(i);
                turn = 0;
                zeroCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printOdd) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            lock.lock();
            try {
                while (turn != 1) {
                    oddCondition.await();
                }
                printOdd.accept(i);
                turn = 0;
                zeroCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
