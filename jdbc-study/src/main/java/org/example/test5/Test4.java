package org.example.test5;

import org.example.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: 19599
 * @Date: 2025/1/9 2:33
 *
 * 模糊查询
 *
 * 此例是想说明sql语句不能写成 select realname from t_user where password like '%?%'
 * 由于占位符 ? 被单引号包围，因此这个占位符是无效的
 */
public class Test4 {
    public static void main(String[] args) {
        /**
         * 查询电话号码第二位是1的
         */
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DbUtils.getConnection();
            String sql = "select realname from t_user where tel like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "_1%");
            rs = ps.executeQuery();

            while (rs.next()) {
                String realname = rs.getString("realname");
                System.out.println(realname);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(con, ps, rs);
        }
    }
}
