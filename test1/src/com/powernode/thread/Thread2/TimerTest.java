package com.powernode.thread.Thread2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: RG
 * @Package: com.powernode.thread.Thread2
 * @name: TimerTest
 * @Date: 2024/11/28 18:54
 */
public class TimerTest {
    /**
     * 定时任务
     * 1. Timer     定时器
     * 2. TimerTask 定时任务
     * <p>
     * 定时器 + 定时任务 可以帮助我们在程序中完成：每间隔多久执行一次某段程序
     * <p>
     * 构造方法
     * 1. Timer()
     * 2. Timer(boolean isDaemon) isDaemon表示该定时器是一个守护线程
     *
     * @param args
     */
    public static void main(String[] args) throws ParseException, InterruptedException {
        // 创建定时器(本质就是一个线程)
        // 如果这个定时器执行的任务是一个后台任务，那么可以定义为守护线程
        Timer timer = new Timer(true);


        // 指定定时
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2024-11-28 19:42:00");

        // 指定定时任务（本质是Runnable接口）
        //  timer.schedule(定时任务，第一次执行时间，间隔多久一次毫秒)
//        timer.schedule(new LogTimerTask(), date, 1000);
        // 也可以用匿名内部类
        timer.schedule(new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                Date date = new Date();
                String time = sdf.format(date);
                System.out.println(time + " : " + count++);
            }
        }, date, 1000);



        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
        }
    }
}

/**
 * 定时任务类，专门记录日期的定时任务类
 */
class LogTimerTask extends TimerTask {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    int count = 0;

    @Override
    public void run() {
        // 执行任务
        Date date = new Date();
        String time = sdf.format(date);
        System.out.println(time + " : " + count++);
    }
}
