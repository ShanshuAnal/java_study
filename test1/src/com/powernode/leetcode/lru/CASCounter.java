package com.powernode.leetcode.lru;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: 19599
 * @Date: 2025/7/9 23:16
 * @Description:
 */
public class CASCounter {
    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        while (true) {
            int expected = counter.get();
            int newValue = expected + 1;
            if (counter.compareAndSet(expected, newValue)) {
                break;
            }
        }
    }

    public int get() {
        increment();
        return counter.get();
    }

    public static void main(String[] args) {
        CASCounter counter = new CASCounter();

        new Thread(() -> {
            int count = 1;
            while (count++ < 10) {
                System.out.println(Thread.currentThread().getName() + "=" + counter.get());
            }
        }, "Thread-1==").start();

        new Thread(() -> {
            int count = 1;
            while (count++ < 10) {
                System.out.println(Thread.currentThread().getName() + "=" + counter.get());
            }
        }, "Thread-2==").start();
    }
}
