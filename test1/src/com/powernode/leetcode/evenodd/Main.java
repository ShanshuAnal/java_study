package com.powernode.leetcode.evenodd;

import java.util.TreeSet;

/**
 * @Author: 19599
 * @Date: 2025/5/21 5:03
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);

        new Thread(() -> {
            try {
                zeroEvenOdd.zero(() -> {
                    System.out.print(0);
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


        System.out.println("-------------------------------");

        EvenOdd evenOdd = new EvenOdd();

        new Thread(() -> {
            try {
                evenOdd.even(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                evenOdd.odd(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
