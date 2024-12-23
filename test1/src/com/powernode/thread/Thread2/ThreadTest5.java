package com.powernode.thread.Thread2;

import java.util.TreeMap;

/**
 * @Author: RG
 * @Package: com.powernode.thread.Thread2
 * @name: ThreadTest5
 * @Date: 2024/11/28 17:29
 */
public class ThreadTest5 {
    /**
     * 如何终止一个线程的执行
     * @param args
     */
    public static void main(String[] args) {
        MyRunnable2 run = new MyRunnable2();
        Thread thread = new Thread(run);
        thread.start();

        // 让线程5秒之后停止
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        stop()从jdk1.2开始就淘汰了
//        thread.stop();

        // 通过对标记进行操作来终止线程
        run.run = false;


    }
}

class MyRunnable2 implements Runnable {

    /**
     * 标记是否继续执行
     */
    boolean run = true;

    @Override
    public void run() {
        if (run) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " === " + i);
            }
        }
    }
}
