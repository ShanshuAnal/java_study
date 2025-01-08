package org.example.test4;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @Author: 19599
 * @Date: 2025/1/8 22:59
 *
 * 获取新增行的主键值
 * 很多表的主键字段都是自增的，在某些业务环境下，我们在插入数据后希望获得这条记录的主键值
 * 可以使用executeUpdate()的重载版本，该方法接受一个额外参数，用于指定是否需要获取自动生成的主键值
 *
 * 1. 在执行executeUpdate方法时指定一个标志位，表示需要返回插入的主键值
 * 2. 调用Statement对象的getGeneratedKeys()方法，返回一个包含插入的主键值的ResultSet对象
 *
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
        ResultSet resultSet = null;


        try {
            // 1. 注册驱动
            Class.forName(driver);

            // 2. 获取连接
            conn = DriverManager.getConnection(url, user, password);

            // 3. 获取数据库对象
            stat = conn.createStatement();

            // 4. 执行SQL
            String sql = "insert into t_product(name, price, create_time) values ('汽车', '166399.99', '2012-12-1')";
            // 第二个参数是标志位，用来表示是否将新插入的数据行的主键值返回
            int count = stat.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("插入了" + count + "条记录");

            // 获取这个新增行的主键值
            // 返回的ResultSet结果集中就有新增行的主键值
            resultSet = stat.getGeneratedKeys();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                System.out.println(id);
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
