package com.powernode.thread.Thread2;

/**
 * @Author: RG
 * @Package: com.powernode.thread.Thread2
 * @name: ThreadTEst7
 * @Date: 2024/11/28 20:25
 */
public class ThreadTest7 {
    /**
     * <h2>关于线程生命周期的JVM调度：</h2>
     *  1. 优先级
     *  2. 线程是可以设置优先级的，优先级高的，获得CPU时间片的概率高一点
     *  3. 采用抢占式调度方式
     *  4. 默认一个线程优先级为5，最低为1，最高位10
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Thread.MIN_PRIORITY);

        System.out.println(Thread.NORM_PRIORITY);

        System.out.println(Thread.MAX_PRIORITY);

        // 获取main线程优先级
        System.out.println(Thread.currentThread().getPriority());
        // 设置优先级
        Thread.currentThread().setPriority(10);
        System.out.println(Thread.currentThread().getPriority());

        MyThread3 thread3 = new MyThread3();
        thread3.setPriority(3);
        thread3.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " ==> " + i);
        }
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " ==> " + i);
        }
    }
}