package com.powernode.IO;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: SystemOutTest
 * @Date: 2024/11/27 13:50
 */
public class SystemOutTest {
    /**
     * 标准输入流 System.out 向控制台输出， 普通输入流向文件/网络输出
     * 是一个全局输入流，不需要手动关闭，JVM退出的时候，JVM会自动退出
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // 改变输入方向
        System.setOut(new PrintStream("test1/log"));

        System.out.println("2werewrewrewr213");
        System.out.println("213asdas");
        System.out.println("213asdas,./");


        // 获取系统当前时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String time = sdf.format(date);
        System.out.println("time:" + time);


        ResourceBundle bundle = ResourceBundle.getBundle("com/powernode/IO/jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        System.out.println(driver);
        System.out.println(url);
        System.out.println(user);
        System.out.println(password);

    }
}
