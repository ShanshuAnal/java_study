package com.powernode.thread.Thread2;

/**
 * 线程通信
 *
 * 1. wait()、notify() 和 notifyAll() 方法
 * 这些方法都是定义在 Object 类中的，因此每个对象都有这些方法。它们通常与同步（synchronized）结合使用，以实现线程之间的通信。
 * 它们不是通过线程对象调用的，而是通过共享对象去调用
 *
 * 1.1 wait()
 * 使当前线程进入等待状态，直到其他线程调用该对象的 notify() 或 notifyAll() 方法。
 * 必须在同步代码块中调用，即调用时需要持有锁。wait()方法调用后，会释放之前占用的对象锁
 *
 * 三个重载：
 * wait()
 * wait(毫秒)
 * wait(毫秒， 纳秒)
 *
 *
 * 1.2 notify()
 * 唤醒一个等待在该对象监视器上的优先级最高的线程，让其进入就绪态，
 * 这个线程会重新获得锁并继续从wait()中断的地方开始执行。
 * 只有当线程在同步代码块内调用时，才能唤醒等待线程。
 *
 *
 *
 * 1.3 notifyAll()
 * 唤醒所有在该共享对象上等待的线程。同样，只有在同步代码块中才能调用。
 *
 * @author 19599
 */
public class ThreadTest13 {
    public static void main(String[] args) {
        Count count = new Count(1);

        Thread t1 = new Thread(new CountRunnbale(count), "t1");
        Thread t2 = new Thread(new CountRunnbale(count), "t2");
        Thread t3 = new Thread(new CountRunnbale(count), "t3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class CountRunnbale implements Runnable {
    private Count count;

    public CountRunnbale(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        count.counting();
    }
}

class Count {
    private int count = 0;

    public Count(int count) {
        this.count = count;
    }

    /*
    实际上就是一个PV题
    EZ

    t1                  线程t1获得对象锁，进入互斥区；线程t2进入阻塞态，等待获得对象锁
    t1 => 1             线程t1执行count++
    t1 is waiting.      线程t1进入等待态并释放对象锁；
    t2                  线程t2获得对象锁回到就绪态，通过JVM调度进入运行态，从而进入互斥区；线程t1进入阻塞态
    t2 => 2             线程t2执行count++
    t2 is waiting.      线程t2进入等待态并释放对象锁；
    t1leaving.          线程t1获得对象锁回到就绪态，通过JVM调度进入运行态，，从wait()中断的地方重新执行
    t1                  线程t1获得对象锁，进入互斥区；线程t2在notify()后进入阻塞态
     */
    public synchronized void counting() {
        while (true) {
            String name = Thread.currentThread().getName();
            System.out.println(name);

            notify();

            if (count > 100) {
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + " => " + count++);

            try {
                System.out.println(name + " is waiting.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + "leaving.");

        }

    }
}