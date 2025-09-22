package com.powernode.leetcode.fizzbuzzmultithreaded;

import java.util.function.IntConsumer;

/**
 * @Author: 19599
 * @Date: 2025/5/14 23:20
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(10);
        new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.fizzBuzz(() -> System.out.println("fizzBuzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.normal(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
