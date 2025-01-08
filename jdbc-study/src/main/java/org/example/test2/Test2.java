package org.example.test2;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: 19599
 * @Date: 2025/1/8 21:12
 *
 * 注册驱动的常用方式
 * 1. Driver driver = new com.mysql.cj.jdbc.Driver();
 *    DriverManager.registerDriver(driver);
 * 2. Class.forName("com.mysql.cj.jdbc.Driver");
 *
 * 在JDBC 4.0（java6+）之后，驱动的注册不再需要手动完成，由系统自动注册
 * 也就是说驱动语句不用写了
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        // 注册驱动
        // 这个代码的作用就是让类加载
        // 而类加载时，会执行静态代码块
        // 在该类的静态代码块中完成了驱动的注册
//        Class.forName("com.mysql.cj.jdbc.Driver");

        // 获取连接
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "zhang914";

        Connection conn = DriverManager.getConnection(url, user, password);

    }
}
/*
static {
    try {
        DriverManager.registerDriver(new Driver());
    } catch (SQLException var1) {
        throw new RuntimeException("Can't register driver!");
    }
}
 */