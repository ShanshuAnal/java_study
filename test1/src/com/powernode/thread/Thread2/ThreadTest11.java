package com.powernode.thread.Thread2;

/**
 * 死锁（Deadlock）
 * 是指在多线程程序中，两个或多个线程在执行过程中因争夺资源而造成一种互相等待的现象，
 * 导致这些线程无法继续执行，程序进入一种“卡住”状态。
 *
 * 死锁产生的四个必要条件
 * 1. 互斥条件（Mutual Exclusion）：
 *      资源不能被多个线程同时占用，至少有一个资源必须处于被占用状态。
 *
 * 2. 持有并等待条件（Hold and Wait）：
 *      至少有一个线程持有一个资源，并且正在等待其他线程持有的资源。
 *
 * 3. 不剥夺条件（No Preemption）：
 *      资源不能强行从正在使用它的线程中剥夺，只有当线程自己释放资源时，其他线程才能获得它。
 *
 * 4. 循环等待条件（Circular Wait）：
 *      存在一种线程资源的循环等待关系，即线程 A 等待线程 B 持有的资源，线程 B 等待线程 C 持有的资源，
 *      线程 C 又等待线程 A 持有的资源。
 *
 * 如果这四个条件同时满足，那么系统就进入了死锁状态。
 *
 *
 *
 * @author 19599
 */
public class ThreadTest11 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        Thread t1 = new Thread(new MyRunnable3(o1, o2));
        Thread t2 = new Thread(new MyRunnable4(o1, o2));

        t1.start();
        t2.start();

    }
}

class MyRunnable3 implements Runnable {
    private Object o1;
    private Object o2;

    public MyRunnable3(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {
                System.out.println(1);
            }
        }
    }
}

class MyRunnable4 implements Runnable {
    private Object o1;
    private Object o2;

    public MyRunnable4(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o2) {
            synchronized (o1) {
                System.out.println(2);
            }
        }
    }
}


