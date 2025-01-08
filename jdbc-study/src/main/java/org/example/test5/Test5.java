package org.example.test5;

import org.example.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: 19599
 * @Date: 2025/1/9 2:40
 *
 * 分页查询
 *
 * 对于MySQL来说，通用的分页SQL语句：
 * 假设每页显示3条记录：pageSize = 3
 *      第1页：limit 0, 3
 *      第2页：limit 3, 3
 *      第3页：limit 6, 3
 *
 * 第pageNo页：limit (pageNo - 1)*pageSize, pageSize
 */
public class Test5 {
    public static void main(String[] args) {
        /**
         * 查询所有用户realname，每页显示3条，显示第2页
         */
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DbUtils.getConnection();
            String sql = "select realname from t_user limit ?,?";
            ps = con.prepareStatement(sql);

            ps.setInt(1,0);
            ps.setInt(2,3);

            rs = ps.executeQuery();

            while (rs.next()) {
                String realname = rs.getString("realname");
                System.out.println("realname: " + realname);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(con, ps, rs);
        }
    }
}
