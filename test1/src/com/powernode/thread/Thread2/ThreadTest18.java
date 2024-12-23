package com.powernode.thread.Thread2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程实现第四种方式：线程池
 * 线程池本质上就是一个缓存：cache
 *
 * 一般都是服务器在启动的时候，初始化线程池，创建N多个线程对象，直接放到线程池中，
 * 需要使用线程对象时，直接从线程池中获取
 */
public class ThreadTest18 {
    public static void main(String[] args) {
        // 创建线程池对象
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // 将任务交给线程池，线程池自己处理
        pool.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + " ==> " + i);
                }
            }
        });

        //最后关闭线程池
        pool.shutdown();

    }
}

