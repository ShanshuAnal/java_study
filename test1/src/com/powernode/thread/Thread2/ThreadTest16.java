package com.powernode.thread.Thread2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁 ReentrantLock
 *
 * 使用Lock来实现线程安全的懒汉式单例模式
 *
 * Lock是接口，有一个实现类 ReentrantLock
 * 要想使用ReentrantLock实现线程安全，那么就要让这些线程共享一个lock，也就是要设置成静态变量
 *
 * Lock 比 synchronized 更好
 * 因为他更加灵活
 *
 */
public class ThreadTest16 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Singleton1Runnable(Singleton1.getinstance()), "t1");
        Thread t2 = new Thread(new Singleton1Runnable(Singleton1.getinstance()), "t2");
        Thread t3 = new Thread(new Singleton1Runnable(Singleton1.getinstance()), "t3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Singleton1Runnable implements Runnable{

    Singleton1 singleton1;

    public Singleton1Runnable(Singleton1 singleton1) {
        this.singleton1 = singleton1;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + singleton1);
    }
}

class Singleton1 {
    private static Singleton1 instance;

    private static final ReentrantLock lock = new ReentrantLock();

    private Singleton1() {}

    public static Singleton1 getinstance() {
        if (instance == null) {
            try {
                // 上锁 P
                lock.lock();
                if (instance == null) {
                    instance = new Singleton1();
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                // 解锁 一定要执行
                lock.unlock();
            }
        }
        return instance;
    }
}


