package org.example.test5;

import org.example.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: 19599
 * @Date: 2025/1/9 1:59
 *
 *  使用PreparedStatement完成新增操作
 */
public class Test1 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DbUtils.getConnection();

            String sql = "insert into t_user(name, password, realname, gender, tel) values(?,?,?,?,?)";

            ps = conn.prepareStatement(sql);

            ps.setString(1, "songqi");
            ps.setString(2, "123123");
            ps.setString(3, "宋七");
            ps.setString(4, "男");
            ps.setString(5, "123123123");

            int i = ps.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(conn, ps, rs);
        }
    }
}
