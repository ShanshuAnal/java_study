package com.powernode.leetcode.fizzbuzzmultithreaded;

import java.util.function.IntConsumer;

/**
 * @Author: 19599
 * @Date: 2025/5/15 8:36
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        FizzBuzz2 fb = new FizzBuzz2(4);

        new Thread(() -> {
            try {
                fb.fizz(() -> {
                    System.out.println("fizz");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fb.buzz(() -> {
                    System.out.println("buzz");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fb.fizzbuzz(() -> {
                    System.out.println("fizzbuzz");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fb.number(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
