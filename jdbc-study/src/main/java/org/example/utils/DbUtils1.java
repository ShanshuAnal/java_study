package org.example.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @Author: 19599
 * @Date: 2025/1/10 1:43
 */
public class DbUtils1 {

    private DbUtils1(){}

    private static DataSource dataSource;

    static {
        try {
            // 获取一个输入流，指向一个属性资源文件
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc2.properties");
            // 创建属性类对象
            Properties prop = new Properties();
            // 将属性配置文件的资源加载到属性类对象中
            prop.load(in);
            // 获取连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
