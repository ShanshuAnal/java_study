package com.powernode.thread.Thread2;

/**
 * 单例模式
 */
public class ThreadTest15 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new SingletonRunnable(Singleton.getInstance()), "t1");
        Thread t2 = new Thread(new SingletonRunnable(Singleton.getInstance()), "t2");
        Thread t3 = new Thread(new SingletonRunnable(Singleton.getInstance()), "t3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class SingletonRunnable implements Runnable {

    Singleton singleton;

    public SingletonRunnable(Singleton singleton) {
        this.singleton = singleton;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + singleton);
    }
}

/**
 * 懒汉式单例模式
 *
 * 双重检查锁定
 * 第一次检查：如果 instance 已经不为 null，则直接返回实例，避免了进入同步块，性能更高。
 *
 * 进入同步块：如果第一次检查发现 instance 为 null，那么线程就会进入同步块，执行实例化的过程。
 *
 * 第二次检查：进入同步块后，线程会再次检查 instance 是否为 null。这样是为了防止在多个线程竞争创建实例时，
 * 多个线程先后进入同步块并尝试创建实例。第二次检查保证了只有一个线程能真正创建实例。
 *
 *
 * 双重检查目的：
 * 1. 性能优化：
 *  如果没有第一次检查，锁会每次都被竞争，无论实例是否已经创建。
 *  而第一次检查可以确保在实例已经创建的情况下，直接跳过同步块，
 *  避免了每次调用 getInstance() 时都加锁，从而大大提升了性能。
 *
 * 2. 线程安全：由于在创建实例时需要同步，双重检查确保了在多线程环境下，
 * 只有一个线程能够创建实例，其他线程会在第二次检查时发现实例已经存在。
 */
class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        // 第一个if是在进入同步块之前进行的，这样可以避免每次调用都进入同步块
        // 它的目的是 尽量减少锁的使用
        if (instance == null) {
            synchronized (Singleton.class) {
                // 这个if是原来if的作用，在并发情况下可能会有多个线程过了第一个if在阻塞态，
                // 这就需要再次检查instance是否被创建了
                // 它的目的是 确保多线程环境下只会有一个线程初始化实例。
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}


