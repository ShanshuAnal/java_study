package com.powernode.thread.Thread2;

import org.junit.jupiter.api.Test;

/**
 * @Author: RG
 * @Package: com.powernode.thread.Thread2
 * @name: ThreadTest3
 * @Date: 2024/11/28 14:32
 */
public class ThreadTest3 {
    /**
     * 关于线程的sleep方法
     * 1. static void sleep(long millis)
     * 静态方法 没有返回值，参数是一个毫秒
     * 2. 作用：
     * 让当前线程进入休眠，放弃所占CPU时间片，进入阻塞状态
     * 阻塞时间为millis参数
     * 在阻塞状态，线程没有权力抢夺时间片
     * 3. 什么是当前线程
     * Thread.sleep(1000); 这个代码出现在哪个线程中，当前线程就是哪个
     * 4. run方法在重写的时候不可以直接抛出异常，因为它实现的接口/重写的父类方法都没有抛出异常
     * 5. sleep可以模拟每个固定的时间调用
     * <p>
     * <p>
     * 如何中断一个线程的睡眠
     * （即解除线程因sleep而导致的阻塞，让其有资格竞争CPU时间片）
     */
    public static void main(String[] args) {
        try {
            // 这段代码出现在主线程中，所以当前线程是主线程
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t = new Thread(new MyRunnable());
        t.setName("tt");
//        t.start();




//        t.sleep(10);
        /*
            问：是t线程睡眠还是主线程睡眠
            解析：首先sleep()是一个静态方法，应该通过类名去调用，也就是说
                 t.sleep()等同于 Thread.sleep()，
                 Thread.sleep()在哪，就是哪个线程进入睡眠
                 所以主线程进入睡眠
         */

    }
}


class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                // 每隔多少毫秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}