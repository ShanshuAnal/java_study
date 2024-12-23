package com.powernode.thread.Thread2;

/**
 * @Author: RG
 * @Package: com.powernode.thread.Thread2
 * @name: ThreadTest10
 * @Date: 2024/11/29 14:43
 */
public class ThreadTest10 {
    /**
     * 分析以下程序，问 m2方法在执行的时候是否要等待m1方法执行完毕？
     * 答：不用
     *
     * 关键点在于对象锁作用范围仅限于被同步的代码部分。
     * 如果一个线程持有某个对象的锁（即该对象的同步方法或同步代码块正在执行），
     * 那么其他线程不能进入该对象的同步方法或同步代码块，但它们可以执行该对象的 非同步方法 或访问 非共享资源。
     *
     */
    public static void main(String[] args) {
        MyClass myClass = new MyClass();

        Thread t1 = new Thread(new MyRunnable1(myClass));
        t1.setName("t1");
        Thread t2 = new Thread(new MyRunnable1(myClass));
        t2.setName("t2");

        t1.start();

        // 此处的作用只是确保m2方法后启动
        System.out.println("main is about to sleep");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main wakes up");

        t2.start();

    }
}

class MyRunnable1 implements Runnable {

    private MyClass myClass;

    public MyRunnable1(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("t1")) {
            myClass.m1();
        }
        if (Thread.currentThread().getName().equals("t2")) {
            myClass.m2();
        }
    }
}

class MyClass {
    public synchronized void m1() {
        System.out.println("m1 start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 over");
    }

    public void m2() {
        System.out.println("m2 begin");
        System.out.println("m2 over");
    }
}
