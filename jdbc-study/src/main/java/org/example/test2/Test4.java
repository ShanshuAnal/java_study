package org.example.test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @Author: 19599
 * @Date: 2025/1/8 21:39
 *
 * getConnection的重载方法
 */
public class Test4 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 1. getConnection(url)
//        String url = "jdbc:mysql://localhost:3306/jdbc?user=root&password=zhang914&useUnicode=true&serverTimezone=Asia/Shanghai&useSSL=true&characterEncoding=utf-8";
//        Connection connection = DriverManager.getConnection(url);
//        System.out.println(connection);

        // 2. getConnection(url, info)
        String url = "jdbc:mysql://localhost:3306/";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "zhang914");
        info.setProperty("useUnicode", "true");
        info.setProperty("serverTimezone", "Asia/Shanghai");
        info.setProperty("useSSL", "true");
        info.setProperty("characterEncoding", "utf-8");


        Connection connection = DriverManager.getConnection(url, new Properties());
        System.out.println(connection);

    }
}
