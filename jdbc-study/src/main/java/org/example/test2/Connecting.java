package org.example.test2;

import java.sql.*;

/**
 * @Author: 19599
 * @Date: 2025/1/8 19:45
 * <p>
 * 使用JDBC程序 向 jdbc.t_user表中插入一条数据
 */
public class Connecting {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;

        try {
            // 1. 注册驱动
            // com.mysql.cj.jdbc.Driver 是 MySQL最核心的类
            // 它实现了 java.sql.Driver 接口

            // 创建核心驱动对象
            Driver driver = new com.mysql.cj.jdbc.Driver();
            // 注册驱动
            DriverManager.registerDriver(driver);

            // 2. 获取连接
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String user = "root";
            String password = "zhang914";
            conn = DriverManager.getConnection(url, user, password);
            // com.mysql.cj.jdbc.ConnectionImpl@35a50a4c
            // 我们不用关心具体的实现类是谁，只需要面向JDBC接口编程
            System.out.println(conn);

            // 3. 获取数据库操作对象
            stat = conn.createStatement();
            // com.mysql.cj.jdbc.StatementImpl@7dc222ae
            System.out.println(stat);

            // 4. 执行SQL语句
            String sql = "insert into t_user(name, password, realname, gender, tel) " +
                    "values('zhaoliu', '123', '赵六', '男', 12345)";

            // 布尔返回值含义：当sql语句是一个DQL语句的时候，并且查询到了结果，返回true
            //              当sql语句是一个dml语句或者没有查询到任何结果的时候，返回false
            // execute方法功能强大，可以执行所有sql语句
//            boolean isSucceed = stat.execute(sql);

            // 凡是执行dml语句（insert update delete），直接用executeUpdate方法
            // 整型返回值代表成功更新了多少条记录
            int i = stat.executeUpdate(sql);
            System.out.println(i > 0);

            // 执行dql语句（select），直接用executeQuery方法

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 释放资源
            // 原则：从小到大，关闭前判断是否为null
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
