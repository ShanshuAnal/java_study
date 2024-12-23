package com.powernode.thread.Thread2;

/**
 * @Author: RG
 * @Package: com.powernode.thread.Thread2
 * @name: ThreadTest8
 * @Date: 2024/11/28 20:33
 */
public class ThreadTest8 {
    /**
     * JVM调度
     * 1. 让位
     * 2. 静态方法 Thread.yield();
     * 3. 让当前线程让位
     * 4. tips:
     * 让位不会让其进入阻塞状态，而是进入就绪状态
     * 5. 只能保证大概率让位，因为它进入就绪态可能又抢到了CPU，
     *    因为java是优先级分配的，它优先级高就可能抢得到
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new MyThread5();
        t1.setName("t1");

        Thread t2 = new MyThread5();
        t2.setName("t2");

        t1.start();
        t2.start();


    }
}

class MyThread5 extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 500; i++) {
            if (Thread.currentThread().getName().equals("t1") && i % 10 == 0) {
                System.out.println(Thread.currentThread().getName() + "让位一次， i = " + i);
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + " ===> " + i);
        }
    }
}
