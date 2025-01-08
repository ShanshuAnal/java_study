package org.example.test2;

import java.sql.*;

/**
 * @Author: 19599
 * @Date: 2025/1/8 20:41
 */
public class Test1 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            // 1. 注册驱动
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            // 2. 获取连接
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String user = "root";
            String password = "zhang914";

             conn = DriverManager.getConnection(url, user, password);

            // 3. 获取数据库对象
             stat = conn.createStatement();

            // 4. 执行SQL语句
            String sql = "insert into t_user(name, password, realname, gender, tel) " +
                    "values('wanger', '123', '王二', '男', '123123')";
            stat.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 资源关闭
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
