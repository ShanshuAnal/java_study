package com.powernode.thread.Thread2;

/**
 * @Author: RG
 * @Package: com.powernode.thread.Thread2
 * @name: ThreadTest14
 * @Date: 2024/11/29 18:01
 */
public class ThreadTest14 {
    public static void main(String[] args) {
        Task task = new Task();

        Thread t1 = new Thread(new TaskRunnable(task), "t1");
        Thread t2 = new Thread(new TaskRunnable(task), "t2");
        Thread t3 = new Thread(new TaskRunnable(task), "t3");

        t1.start();
        t2.start();
        t3.start();
    }
}


class TaskRunnable implements Runnable {

    private Task task;

    public TaskRunnable(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.run();
    }
}

class Task {
    private int count = 0;

    public void run() {
        while (count <= 100) {
            synchronized (this) {
                if (count % 3 == getThreadIndex()) {
                    System.out.println(Thread.currentThread().getName() + " => " + count++);
                    notifyAll();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private int getThreadIndex() {
        String name = Thread.currentThread().getName();
        if (name.equals("t1")) {
            return 0;
        } else if (name.equals("t2")) {
            return 1;
        } else {
            return 2;
        }
    }
}
