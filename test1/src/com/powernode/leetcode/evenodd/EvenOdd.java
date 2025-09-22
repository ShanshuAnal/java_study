package com.powernode.leetcode.evenodd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Author: 19599
 * @Date: 2025/5/31 12:27
 * @Description:
 */
public class EvenOdd {
    private final Semaphore odd = new Semaphore(1);
    private final Semaphore even = new Semaphore(0);

    public void even(IntConsumer printEven) throws InterruptedException {
        for (int i = 2; i <= 100; i += 2) {
            even.acquire();
            printEven.accept(i);
            odd.release();
        }
    }

    public void odd(IntConsumer printOdd) throws InterruptedException {
        for (int i = 1; i <=100 ; i += 2) {
            odd.acquire();
            printOdd.accept(i);
            even.release();
        }
    }
}
