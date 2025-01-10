package org.example.test7;

import org.example.utils.DbUtils;

import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @Author: 19599
 * @Date: 2025/1/9 20:47
 *
 * 通过jdbc调用存储过程
 */
public class Test3 {
    public static void main(String[] args) {
        Connection con = null;
        // 专门执行存储过程的
        // 它继承了 PreparedStatement
        CallableStatement cs = null;

        try {
            con = DbUtils.getConnection();

            // 调用存储过程的SQL语句
            String sql = "{call mypro(?,?)}";

            cs = con.prepareCall(sql);

            cs.setInt(1, 100);

            // 将第二个占位符 ? 注册为出参
            // 并且出参的类型是整数类型
            cs.registerOutParameter(2, Types.INTEGER);

            // 调用存储过程
            cs.execute();

            // 获取执行结果，执行结果在出参上，获取出参的值
            int i = cs.getInt(2);
            System.out.println(i);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(con, cs, null);
        }
    }
}
