package com.powernode.leetcode.printinorder;

/**
 * @Author: 19599
 * @Date: 2025/5/15 8:08
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Foo1 foo = new Foo1(10);

        new Thread(() -> {
            try {
                foo.first(() -> {
                    System.out.println("first");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                foo.second(() -> {
                    System.out.println("second");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                foo.third(() -> {
                    System.out.println("third");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }


}
