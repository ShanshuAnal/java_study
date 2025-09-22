package com.powernode.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 19599
 * @Date: 2025/7/11 22:32
 * @Description:
 */
public class MyThreadPool {
    /**
     * 工作线程集合
     */
    private List<Worker> workers;

    /**
     * 阻塞队列
     * 用于存储待执行的任务
     */
    BlockingQueue<Runnable> taskQueue;

    /**
     * 线程池的大小
     */
    private int capacity;

    /**
     * 线程池当前运行状态
     * volatile保证多线程下的可见性
     */
    private volatile boolean isRunning;

    public MyThreadPool(int capacity) {
        this.capacity = capacity;
        workers = new ArrayList<>(capacity);
        taskQueue = new LinkedBlockingDeque<>(capacity);
        isRunning = true;
    }

    /**
     * 提交执行任务的方法
     *
     * @param task 待执行的任务
     * @throws InterruptedException 如果在任务放入队列时，线程被中断
     */
    public void execute(Runnable task) throws InterruptedException {
        if (!isRunning) {
            throw new IllegalStateException("the thread pool has been closed");
        }
        if (workers.size() < capacity) {
            synchronized (workers) {
                if (workers.size() < capacity) {
                    Worker worker = new Worker();
                    workers.add(worker);
                    worker.start();
                }
            }
        }
        taskQueue.put(task);
    }

    public void stop() {
        isRunning = false;
        for (Worker worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("线程池已关闭");
    }

    /**
     * 工作线程
     * 可以复用
     */
    class Worker extends Thread {
        @Override
        public void run() {
            /*
             * 复用线程的关键所在
             * 使用一个循环不断地从任务队列中获取数据
             * 当线程池停止运行 并且 任务队列为空时，就推出循环
             * */
            while (isRunning || !taskQueue.isEmpty()) {
                Runnable task = null;
                try {
                    // 从任务队列中获取任务
                    // 使用poll并设置超时，可以防止在线程池停止运行后，如果队列已经空了，线程会无限期阻塞在take()上
                    //task = taskQueue.take();
                    task = taskQueue.poll(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    // 如果在等待任务时被中断，就退出循环
                    break;
                }
                if (task != null) {
                    try {
                        task.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int taskNo = i;
            pool.execute(() -> {
                System.out.println("task " + taskNo + " is running!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("task " + taskNo + " is finished!");
            });
        }

        Thread.sleep(5000);
        pool.stop();
    }
}
