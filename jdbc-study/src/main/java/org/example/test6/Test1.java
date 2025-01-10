package org.example.test6;

import org.example.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: 19599
 * @Date: 2025/1/9 19:34
 *
 * JDBC 批处理操作
 *
 * 1. 不用批处理操作向t_emps表中插入一万条记录，记录耗时
 * count: 10000
 * time: 28006
 */
public class Test1 {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbUtils.getConnection();
            String sql = "insert into t_emps(id, name) values(?,?)";
            ps = conn.prepareStatement(sql);

            int count = 0;
            for (int i = 1; i <= 10000; i++) {
                ps.setLong(1, i);
                ps.setString(2, "emp" + i);
                count += ps.executeUpdate();
            }

            System.out.println("count: " + count);

            long end = System.currentTimeMillis();

            System.out.println("time: " + (end - begin));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(conn, ps, null);
        }
    }
}
