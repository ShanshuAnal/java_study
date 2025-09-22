package com.powernode.leetcode.fizzbuzzmultithreaded;

import org.junit.jupiter.api.parallel.Execution;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Author: 19599
 * @Date: 2025/5/21 4:10
 * @Description:
 */
public class FizzBuzz2 {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private int n;
    private int cur = 1;

    FizzBuzz2(int n) {
        this.n = n;
    }
 
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (cur <= n && !(cur % 3 == 0 && cur % 5 != 0)) {
                    condition.await();
                }
                if (cur > n) {
                    break;
                }
                printFizz.run();
                cur++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (cur <= n && !(cur % 3 != 0 && cur % 5 == 0)) {
                    condition.await();
                }
                if (cur > n) {
                    break;
                }
                printBuzz.run();
                cur++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzbuzz) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (cur <= n && cur % 15 != 0) {
                    condition.await();
                }
                if (cur > n) {
                    break;
                }
                printFizzbuzz.run();
                cur++;
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (cur <= n && cur % 3 == 0 || cur % 5 == 0) {
                    condition.await();
                }
                if (cur > n) {
                    break;
                }
                printNumber.accept(cur);
                cur++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
