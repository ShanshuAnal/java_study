package org.example.test5;

import org.example.utils.DbUtils;

import java.sql.*;

/**
 * @Author: 19599
 * @Date: 2025/1/9 2:03
 *
 * 修改操作
 */
public class Test2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DbUtils.getConnection();

            String sql = "update t_user set gender = ? where name = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, "女");
            ps.setString(2, "songqi");

            int i = ps.executeUpdate();
            System.out.println(i);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(conn, ps, rs);
        }
    }
}
