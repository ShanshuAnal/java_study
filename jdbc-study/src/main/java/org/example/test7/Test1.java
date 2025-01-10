package org.example.test7;

import org.example.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: 19599
 * @Date: 2025/1/9 19:55
 *
 * 事务
 * 事务是一个完整的业务，在这个业务中需要多条DML语句共同联合才能完成
 * 事务可以保证多条DML语句同时成功或者同时失败，从而保证数据是安全的
 * 四大特性 ACID
 *      1. 原子性
 *      2. 一致性
 *      3. 隔离性
 *      4. 持久性
 *
 * 在JDBC中，事务是默认自动提交的，就是只要DML语句执行一次，那就提交一次
 *
 * 实现转账功能
 *
 * 添加事务控制
 *      1. 将JDBC的事务自动提交机制修改为手动提交————开启事务
 *      2. 当整个业务完整结束后，手动提交事务————提交事务、事务结束
 *      3. 在处理业务的过程中，如果发生异常，那么进行catch语句块进行异常处理
 *          手动滚回事务————回滚事务、事务结束
 *
 */
public class Test1 {
    public static void main(String[] args) {
        // 转账金额
        double money = 10000;

        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            con = DbUtils.getConnection();

            // 开启事务，将JDBC的事务自动提交机制修改为手动提交
            con.setAutoCommit(false);

            // 将act-001的账户余额减去10000
            String sql1 = "update t_act set balance = balance - ? where actno = ?";

            ps1 = con.prepareStatement(sql1);
            ps1.setDouble(1, 10000.0);
            ps1.setString(2, "act-001");

            int count1 = ps1.executeUpdate();

            String s = null;
            s.equals("123");

            // 将act-002的账户余额加上10000
            String sql2 = "update t_act set balance = balance + ? where actno = ?";
            ps2 = con.prepareStatement(sql2);

            ps2.setDouble(1, money);
            ps2.setString(2, "act-002");

            int count2 = ps2.executeUpdate();

            // 提交事务、事务结束，当整个业务完整结束后，手动提交事务
            con.commit();

        } catch (Exception e) {
            // 回滚事务、事务结束。只要有任何异常发生，直接回滚事务
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(con, ps1, null);
            DbUtils.close(con, ps2, null);
        }
    }
}
