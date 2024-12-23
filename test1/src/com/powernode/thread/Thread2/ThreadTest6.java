package com.powernode.thread.Thread2;

/**
 * @Author: RG
 * @Package: com.powernode.thread.Thread2
 * @name: ThreadTest6
 * @Date: 2024/11/28 18:00
 */
public class ThreadTest6 {
    /**
     * 在java中，线程被分为两类
     * 1. 用户线程（非守护线程）
     * 2. 守护线程
     *
     * 在JVM当中，有一个隐藏的守护线程——GC线程，就是垃圾回收线程
     *
     * 守护线程在所有用户线程结束后自动结束
     *
     * thread.setDamon(true);
     */
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        // 启动线程之前，设置线程为守护线程
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " == " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class MyThread extends Thread {

    int i = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " === " + i++);
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
