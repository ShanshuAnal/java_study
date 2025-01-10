package org.example.test8;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author: 19599
 * @Date: 2025/1/10 0:42
 *
 * druid连接池的使用
 */
public class Test1 {
    public static void main(String[] args) throws Exception{
        // 获取一个输入流，指向一个属性资源文件
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc2.properties");
        // 创建属性类对象
        Properties prop = new Properties();
        // 将属性配置文件的资源加载到属性类对象中
        prop.load(in);
        // 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        // 通过连接池获取连接对象
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        // 操作...

        // 关闭资源
        // 这个不是真正的关闭，只是将该连接对象的状态设置为空闲
        conn.close();


    }
}
