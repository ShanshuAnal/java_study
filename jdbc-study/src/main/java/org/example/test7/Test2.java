package org.example.test7;

import org.example.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: 19599
 * @Date: 2025/1/9 20:33
 *
 * 在JDBC中，使用Java设置事物的隔离级别
 *
 */
public class Test2 {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DbUtils.getConnection();

            // 设置当前事务的隔离原则
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(conn, null, null);
        }
    }
}
