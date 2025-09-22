package com.powernode.leetcode.deadlock;

/**
 * @Author: 19599
 * @Date: 2025/6/29 21:44
 * @Description:
 */
public class DeadLock {
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (LOCK1) {
                System.out.println("a gets LOCK1");
                try {
                    Thread.sleep(1000);

                    synchronized (LOCK2) {
                        System.out.println("a gets LOCK2");
                        System.out.println("a is running");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {
            synchronized (LOCK2) {
                System.out.println("b gets LOCK2");
                try {
                    Thread.sleep(1000);

                    synchronized (LOCK1) {
                        System.out.println("b gets LOCK1");
                        System.out.println("b is running");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
