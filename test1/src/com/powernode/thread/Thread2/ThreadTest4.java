package com.powernode.thread.Thread2;

import com.powernode.map.UserDemo;

/**
 * @Author: RG
 * @Package: com.powernode.thread.Thread2
 * @name: ThreadTest4
 * @Date: 2024/11/28 16:56
 */
public class ThreadTest4 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        // 中断线程睡眠
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " ==== begin");
                try {
                    Thread.sleep(1000 * 1000 * 1000);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " ==== do some");

                UserDemo user = null;
                try {
                    user.getAge();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        });
        thread.start();

        System.out.println(Thread.currentThread().getName() + "：开始计时5s");
        // 要求它5秒后解除睡眠起来干活
        // 下面这点代码只是让它间隔5秒执行
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /* 这行代码的作用是终止thread线程的睡眠，interrupt()是一个实例方法
         * interrupt()执行的时候，如果thread线程正在睡眠，那么就会立即抛出异常InterruptedException，然后终止睡眠
         * 由于这里的操作是打印异常堆栈信息，故底下的dosome还可以执行到；果是throw，那么dosome就执行不到了
         * */

        thread.interrupt();


        /* 就算是thread抛出异常，这里也会执行
         * 原因：
         * 1. 线程的独立性
         * 主线程和子线程是独立的执行路径，子线程的异常不会直接影响主线程的执行。
         * 2. 异常的传播范围
         * 子线程的异常没有传播到主线程。因此，主线程继续按照其自己的执行路径向下运行。
         * 3. Java 程序终止条件
         * 除非所有非守护线程都结束，或主线程本身抛出未捕获的异常，否则 Java 应用程序不会终止。
         * */
        System.out.println(Thread.currentThread().getName() + " : 五秒过去了");

    }
}
