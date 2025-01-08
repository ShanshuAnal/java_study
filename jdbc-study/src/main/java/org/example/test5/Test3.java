package org.example.test5;

import org.example.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: 19599
 * @Date: 2025/1/9 2:12
 *
 * 删除操作
 */
public class Test3 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            try {
                conn = DbUtils.getConnection();
                String sql = "delete from t_user where name = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "wanger");
                pstmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } finally {
            DbUtils.close(conn, pstmt, null);
        }
    }
}
