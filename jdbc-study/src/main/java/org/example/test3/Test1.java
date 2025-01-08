package org.example.test3;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @Author: 19599
 * @Date: 2025/1/8 22:04
 *
 * 使用jdbc完成查询操作
 */
public class Test1 {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc1");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection conn = null;
        Statement stat = null;

        try {
            // 1. 注册驱动
            Class.forName(driver);

            // 2. 获取连接
            conn = DriverManager.getConnection(url, user, password);

            // 3. 获取数据库对象
            stat = conn.createStatement();

            // 4. 执行SQL
            String sql = "select * from t_user";
            ResultSet resultSet = stat.executeQuery(sql);

            // 5. 处理查询结果集

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
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
}
