package org.example.test1;

/**
 * @Author: 19599
 * @Date: 2025/1/8 18:13
 */
public class MySQLDriver implements JDBC{
    @Override
    public void connect() {
        System.out.println("mysql connection established");
    }
}
