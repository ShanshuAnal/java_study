package com.powernode.thread.Thread2;

/**
 * @Author: RG
 * @Package: com.powernode.thread.Thread2
 * @name: ThreadTest9
 * @Date: 2024/11/28 20:44
 */
public class ThreadTest9 {
    /**
     * <h2>线程安全</h2>
     * <p>
     * 考虑线程安全问题的情况
     * 1. 多线程并发的情况
     * 2. 有共享的数据
     * 3. 共享数据涉及到修改操作
     * <p>
     * 1. 一般情况下，局部遍历不存在安全问题（基本数据类型不涉及【在虚拟机栈中，是线程私有的】，引用数据变量就不好说）
     * 2. 实例变量和静态变量可能存在线程安全问题，因为它们都存在堆中，堆是多线程共享的
     *
     * 3. 线程同步：多个线程在运行时需要彼此协同，通常一个线程需要等待另一个线程完成某个操作后才能继续
     *            确保任务按一定顺序执行，避免共享资源竞争和不一致
     *    （1）有序执行：一个线程的任务会阻塞，直到另一个线程的任务完成。
     *    （2）线程等待：线程之间存在依赖关系，通常一个线程需要等待资源或信号。
     *    （3）数据一致性：同步确保多个线程对共享资源的访问是有序且安全的。
     *
     * 4. 线程异步：线程之间独立运行，不用等待其他线程或者任务完成，不存在依赖关系
     *            异步机制通过回调、事件或消息队列实现线程间的松耦合。
     *    （1）并发性高：线程可以独立执行，避免等待。
     *    （2）无需阻塞：任务的结果通过回调或事件通知获取。
     *    （3）任务解耦：线程间几乎没有依赖关系。
     */
    public static void main(String[] args) {
        Account user1 = new Account("user-111", 1000);

        Thread t1 = new Thread(new WithdrawThread(user1));

        Thread t2 = new Thread(new WithdrawThread(user1));

        t1.start();
        t2.start();

    }
}

/**
 * 取款线程类
 */
class WithdrawThread implements Runnable {

    private Account account;

    public WithdrawThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.withdraw(100);
    }
}

/**
 * 银行账户
 */
class Account {

    private String actNo;

    private double balance;

    public Account(String actNo, double balance) {
        this.actNo = actNo;
        this.balance = balance;
    }

    public String getActNo() {
        return actNo;
    }

    public void setActNo(String actNo) {
        this.actNo = actNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * <h2>取款的方法</h2>
     * <code>sychronized</code> 是 Java 中用于实现线程同步的关键字<p>
     * 它确保在多线程环境中对共享资源（如变量、对象或方法）的访问是线程安全的，也就是大名鼎鼎的互斥锁<p>
     * <code>sychronized</code> 关键字可以用来修饰<B>方法或者代码块,实例变量不行</B>，
     * 确保同一时刻只有一个线程能访问被修饰的代码<p>
     * <p>
     * 语法格式：
     * sychronized(共享资源) {
     *     // 需要同步的代码
     * }
     *
     * <h4>原理：</h4>
     * 1. 当一个线程调用 withdraw 方法时，它会获得该方法所属对象的锁。<p>
     * 如果另一个线程也试图调用该方法，它将必须等待当前线程释放锁。<p>
     * 2. 如果多个线程同时试图访问该方法，只有一个线程能够获得锁，其它线程会被阻塞，直到锁被释放。<p>
     *
     * <h4>实例</h4>
     * 在这个例子中，withdraw是一个同步实例，每个线程调用withdraw时，它都必须要先获得Account对象的锁<p>
     * 如果另一个线程也试图调用该方法，它就会被阻塞，直到当前线程释放对象的锁<p>
     *
     * <h4>锁的释放</h4>
     * 当线程退出同步方法或同步代码块时，会自动释放对象锁。
     * 如果线程在同步代码块中抛出异常，它也会释放对象锁，防止死锁。
     *
     * <h4>对象锁的工作机制</h4>
     * 1. 每个 Java 对象都有一个与之关联的锁（Java 使用对象的内置监视器<B>monitor</B>来实现对象锁）。
     * 2. 当线程调用同步实例方法或者进入同步代码块时，它会试图获取该对象的锁。
     * 3. 如果另一个线程已经持有该对象的锁，当前线程会被阻塞，直到锁被释放。
     * 4. 同一时刻，只能有一个线程持有对象的锁，其他线程需要等待。
     * 5. 对象锁是粒度较小的锁，因为它是针对特定对象实例的，而不是类级别的锁。
     *
     * @param money
     */
    // synchronized
    public synchronized void withdraw(double money) {
        // 想要演示多线程并发带来的安全问题，要分两步完成取款操作
        // 一 读取余额
        double before = this.getBalance();
        System.out.println(Thread.currentThread().getName()
                + " is withdrawing, and the balance is : "
                + before);

        // 二 修改余额
        this.setBalance(before - money);
        System.out.println(Thread.currentThread().getName() +
                " has withdrew, and the balance is : " +
                this.getBalance());
    }

    // 也可以这么写  同步代码块（synchronized block）语法
    /*public void withdraw(double money) {
        synchronized(this) {
            double before = this.getBalance();
            System.out.println(Thread.currentThread().getName()
                    + " is withdrawing, and the balance is : "
                    + before);

            this.setBalance(before - money);
            System.out.println(Thread.currentThread().getName() +
                    " has withdrew, and the balance is : " +
                    this.getBalance());
        }
    }*/

}











