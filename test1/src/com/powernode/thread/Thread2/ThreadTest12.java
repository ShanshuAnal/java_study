package com.powernode.thread.Thread2;

/**
 * @author 19599
 */
public class ThreadTest12 {
    public static void main(String[] args) {
        HuangNiu huangNiu = new HuangNiu();
        Thread t1 = new Thread(huangNiu, "HN-1");
        Thread t2 = new Thread(huangNiu, "HN-2");
        Thread t3 = new Thread(huangNiu, "HN-3");

        t2.start();
        t1.start();
        t3.start();
    }
}


class HuangNiu implements Runnable {

    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + " bought a ticket. Remaining tickets: " + --tickets);
                } else {
                    System.out.println(Thread.currentThread().getName() + ", tickets sell out!");
                    break;
                }
            }
        }
    }
}
