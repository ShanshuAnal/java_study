package org.example.test3;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

/**
 * @Author: 19599
 * @Date: 2025/1/8 22:48
 *
 * 获取结果集元数据信息
 *
 * 通过ResultSetMetaData来获取
 */
public class Test3 {
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
            String sql = "select * from t_product";
            resultSet = stat.executeQuery(sql);

            // 5. 处理查询结果集
            // 通过结果集ResultSet 获取元数据 ResultsetMetaData
            // 通过元数据可以获取列的信息：列明、列长度、列的数据类型...
            ResultSetMetaData metaData = resultSet.getMetaData();

            // 获取列的数量
            int columnCount = metaData.getColumnCount();
            System.out.println(columnCount);

            // 遍历每一列
            for (int i = 1; i <= columnCount; i++) {
                // 获取列名
                String name = metaData.getColumnName(i);

                // 获取列数据类型
                String type = metaData.getColumnTypeName(i);


                // 获取列的长度
                int size = metaData.getColumnDisplaySize(i);

                System.out.println("name: " + name + ", type: " + type + ", size: " + size);

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
