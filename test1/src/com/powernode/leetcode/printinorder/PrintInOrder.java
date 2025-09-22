package com.powernode.leetcode.printinorder;

/**
 * @Author: 19599
 * @Date: 2025/5/14 21:18
 * @Description:
 */
public class PrintInOrder {
    public static void main(String[] args) {
        Foo foo = new Foo(10);

        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
