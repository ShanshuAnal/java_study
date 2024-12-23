package com.powernode.thread.Thread1;

import org.junit.jupiter.api.Test;

/**
 * @Author: RG
 * @Package: com.powernode.thread
 * @name: ThreadTest1
 * @Date: 2024/11/28 11:59
 */
public class ThreadTest1 {
    /**
     * 实现线程的两种方式
     * 1. 继承Thread，重写run()方法
     * （1） 编写一个类，继承Thread
     * （2） 重写（override）run方法，重载（overload）是定义多个方法名相同但参数列表不同的方法
     * （3） new线程对象
     * （4） 调用线程对象的start()方法来启动线程
     * 2. 实现Runnable接口，重写 run()方法
     * （1） 编写一个类，实现Runnable接口
     * （2） 实现run方法
     * （3） new线程对象  new Thread(new Runnable());
     */
    @Test
    // 用这个test来带起main方法
    public void test1() {
        Thread t = new MyThread();

        // java的语法规则，对于方法体中的代码，必须遵循自上而下的顺序依次逐行执行
        // start()方法不结束，main方法是无法继续执行的
        // start()方法一旦执行会瞬间结束，因为这个方法的作用是启动一个新线程，只要线程启动了他就结束了

        // 调用start()方法，启动新线程
        t.start();


        // 调用run，不会启动新线程
//        t.run();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }

    }

    /**
     * 进程实现的第二种方式
     */
    @Test
    public void test2() {
        Thread thread = new Thread(new MyRunnable());

//        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("anonymous: " + i);
                }
            }
        }).start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

    /**
     * 测试线程常用方法
     */
    @Test
    public void test3() {
        // 获取当前线程
        Thread thread = Thread.currentThread();

        // 获取当前线程的名字
        String name = thread.getName();
        System.out.println(name);

        MyThread myThread = new MyThread();
        System.out.println(myThread.getName());

        // 修改线程名字
        thread.setName("cnm");
        System.out.println(Thread.currentThread().getName());

        // 通过构造函数指定名字
        Thread thread1 = new Thread("haha");
        System.out.println(thread1.getName());

    }
}

/**
 * 自定义一个线程类
 * Thread本身就是一个线程对象，因此MyThread本身也是一个线程
 * <p>
 * <p>
 * 常用方法
 *  实例方法
 *      1. String getName(); 获取线程的名字
 *      2. void setName(String name); 设置线程的名字
 *  静态方法
 *      1. static Thread currentThread(); 获取当前线程
 */
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName() + ": " + i);
        }
    }
}


/**
 * 严格来说，他不是一个线程类
 * 她只是一个普通类，只不过实现了Runnable接口
 */
class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyRunnable: " + i);
        }
    }
}

