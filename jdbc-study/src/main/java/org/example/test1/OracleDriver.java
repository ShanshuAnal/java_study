package org.example.test1;

/**
 * @Author: 19599
 * @Date: 2025/1/8 18:14
 */
public class OracleDriver implements JDBC {
    @Override
    public void connect() {
        System.out.println("Oracle connection established");
    }
}
