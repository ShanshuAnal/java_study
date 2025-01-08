package org.example.test3;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

/**
 * @Author: 19599
 * @Date: 2025/1/8 22:39
 * <p>
 * 以特定的类型获取返回数据
 */
public class Test2 {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc1");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection conn = null;
        Statement stat = null;
        ResultSet resultSet = null;


        try {
            // 1. 注册驱动
            Class.forName(driver);

            // 2. 获取连接
            conn = DriverManager.getConnection(url, user, password);

            // 3. 获取数据库对象
            stat = conn.createStatement();

            // 4. 执行SQL
            String sql = "select name a, price p, create_time time from t_product";
            resultSet = stat.executeQuery(sql);

            // 5. 处理查询结果集
            // 进行格式化显示
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // 这里直接打印输出
            while (resultSet.next()) {
                // 去除光标指向的当前行的数据
                // 不管数据库表中是什么类型，统一以字符串的类型取出
                // 根据查询结果集里的列名 和 列下标获取均可
                String name = resultSet.getString("a");
                double price = resultSet.getDouble("p");
                Date time = resultSet.getDate("time");

                // 将 java.sql.Date 转换为 java.util.Date
                java.util.Date date = new java.util.Date(time.getTime());
                String format = sdf.format(date);

                System.out.println("Name: " + name + ", Price: " + price + ", date: " + format);

            }


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
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