package com.powernode.leetcode.fizzbuzzmultithreaded;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Author: 19599
 * @Date: 2025/5/14 23:10
 * @Description:
 */
public class FizzBuzz {
    private final int n;
    /**
     * 1. 这里的 cur++ 要不要加 volatile
     * 不需要。
     * 原因很简单：cur 是在所有访问处都被 lock 串行化保护的，也就是说：
     * 所有线程在访问 cur（包括读取和修改）时，都必须先获取 lock。
     * 这就保证了内存可见性（等同于 volatile），并且还有原子性。
     * ✅ 总结：
     * 当你已经用显式锁（如 ReentrantLock）包围所有访问路径时，不需要再加 volatile。
     * <p>
     * 2. 是不是线程安全的
     * cur++在 lock.lock() 内部执行的，所有对 cur 的访问都是互斥的，根本不会有两个线程同时操作。
     * ✅ 总结：
     * cur++ 本身不是原子操作，但只要你放在锁保护范围内，就可以放心使用，不存在并发问题。
     */
    private int current = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (current <= n && !(current % 3 == 0 && current % 5 != 0)) {
                    condition.await();
                }
                if (current > n) {
                    break;
                }
                printFizz.run();
                current++;
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
                while (current <= n && !(current % 5 == 0 && current % 3 != 0)) {
                    condition.await();
                }
                if (current > n) {
                    break;
                }
                printBuzz.run();
                current++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void fizzBuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (current <= n && !(current % 5 == 0 && current % 3 == 0)) {
                    condition.await();
                }
                if (current > n) {
                    break;
                }
                printFizzBuzz.run();
                current++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void normal(IntConsumer printNormal) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (current <= n && current % 3 == 0 || current % 5 == 0) {
                    condition.await();
                }
                if (current > n) {
                    break;
                }
                printNormal.accept(current);
                current++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

}
