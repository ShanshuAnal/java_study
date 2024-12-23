package com.powernode.thread.Thread2;

/**
 * @Author: RG
 * @Package: com.powernode.thread.Thread2
 * @name: ThreadJoinTest
 * @Date: 2024/11/28 19:52
 */
public class ThreadJoinTest {
    /**
     * <h2>线程合并</h2>
     * 1. 调用<code>join()</code>方法完成合并<p>
     * 2. <code>join()</code>方法是一个实例方法，不是静态方法，因为合并是针对一个特定的线程的<p>
     * 3. 若一个线程t在main方法中调用了<code>join()</code>方法，那么线程t会被合并到主线程中去
     * 然后主线程会进入阻塞状态，直到t线程执行结束，接着主线程阻塞解除<p>
     * 4. 实际上<code>join()</code>方法是让当前线程进入阻塞状态，直到线程t执行完毕，接着当前线程才接触阻塞状态<p>
     * 5. 与sleep()方法异同<p>
     * 异：<p>
     * （1） sleep方法是静态方法，join方法是实例方法<p>
     * （2） sleep方法可以指定睡眠的时长，join方法不能保证阻塞的时长<p>
     * （3） sleep方法的阻塞解除条件：睡眠时间完毕；join方法的阻塞解除条件：调用join方法的进程执行完毕<p>
     * 同：<p>
     * （1） sleep的join方法都是让当前线程进入阻塞状态
     *
     * @param args
     */
    public static void main(String[] args) {
        MyThread1 thread = new MyThread1();
        thread.start();

        // 合并线程
        // thread合并到主线程中，主线程收到阻塞，直到thread运行完毕
        try {
//            thread.join();

            // 调用这个方法，是想让当前线程受阻10秒
            // 但不一定起作用，如果在指定的阻塞时间内，t线程结束了，当前线程阻塞也会解除
            thread.join(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 主线程
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " ===> " + i);
        }


    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " ===> " + i);
        }
    }
}




























