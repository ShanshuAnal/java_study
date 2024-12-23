package com.powernode.thread.Thread2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现线程的第三种方式：实现Callable接口，实现call方法
 * 这种实现方式是可以获取到线程返回值的
 */
public class ThreadTest17 {
    public static void main(String[] args) {
        // 创建“未来任务”对象
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });

        // 创建线程对象
        Thread t1 = new Thread(futureTask);

        t1.start();

        // 获取未来任务的返回值
        // 阻塞当前线程，等待“未来任务”结束并返回值
        // 拿到返回值，当前线程解除阻塞状态，进入就绪态
        try {
            Integer i = futureTask.get();
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
