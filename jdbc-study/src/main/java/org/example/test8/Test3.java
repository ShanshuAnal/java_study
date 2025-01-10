package org.example.test8;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author: 19599
 * @Date: 2025/1/10 2:02
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        InputStream in = HikariConfig.class.getClassLoader().getResourceAsStream("jdbc3.properties");
        Properties props = new Properties();
        props.load(in);
        HikariConfig config = new HikariConfig(props);
        DataSource dataSource = new HikariDataSource(config);
        Connection conn = dataSource.getConnection();

        System.out.println(conn);

        conn.close();
    }
}
