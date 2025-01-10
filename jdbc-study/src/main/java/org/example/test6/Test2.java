package org.example.test6;

import org.example.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: 19599
 * @Date: 2025/1/9 19:42
 *
 * 2. 使用批处理操作，记录插入时间
 * count: 10001
 * time: 26834
 */
public class Test2 {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbUtils.getConnection();
            String sql = "insert into t_emps(id, name) values(?,?)";
            ps = conn.prepareStatement(sql);

            int count = 0;
            for (int i = 1; i <= 10001; i++) {
                ps.setLong(1, i);
                ps.setString(2, "emp" + i);
                // 打包
                ps.addBatch();
                if (i % 500 == 0) {
                    // 批量执行
                    count += ps.executeBatch().length;
                }
            }

            // 循环结束之后，再次执行批处理防止数据丢失
            count += ps.executeBatch().length;


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
