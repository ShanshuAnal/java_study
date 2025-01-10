package org.example.test8;

import org.example.utils.DbUtils1;

import java.sql.Connection;

/**
 * @Author: 19599
 * @Date: 2025/1/10 1:54
 *
 * 使用改造后的JDBC工具
 */
public class Test2 {
    public static void main(String[] args) throws Exception{
        Connection conn = DbUtils1.getConnection();
        System.out.println(conn);
        conn.close();


        Connection conn1 = DbUtils1.getConnection();
        System.out.println(conn1);
        conn1.close();


        Connection conn2 = DbUtils1.getConnection();
        System.out.println(conn2);
        conn2.close();

        Connection conn3 = DbUtils1.getConnection();
        System.out.println(conn3);
        conn3.close();
    }
}
