package org.example.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @Author: 19599
 * @Date: 2025/1/8 23:22
 */
public class DbUtils {

    /**
     * 工具类的私有方法一般都是私有化的
     * 因为工具类中的一般静态的，工具类就是方便编程
     * 所以工具类中的方法都是直接采用“类名.”的方式进行访问
     * 因此不需要new对象
     */
    private DbUtils(){}

    /**
     * 静态变量
     */
    private static String driver;

    private static String url;

    private static String user;

    private static String password;

    /**
     * 静态代码块
     * 对于整个应用程序来说，注册驱动主要做一次，所以用静态代码块
     * 静态代码块在类加载的时候执行，且只执行一次
     */
    static {
        // 读取配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc1");

        // 给静态变量赋值
        driver = bundle.getString("driver");
        url = bundle.getString("url");
        user = bundle.getString("user");
        password = bundle.getString("password");

        // 注册驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据库连接对象
     * @return Connection 数据库操作对象
     * @throws SQLException sql异常
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }


    /**
     * 释放资源
     * @param conn  连接对象
     * @param stmt  数据库操作对象
     * @param rs    结果集对象
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
