package org.example.SqlInject;

import org.example.utils.DbUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author: 19599
 * @Date: 2025/1/8 23:53
 *
 * SQL注入
 *
 * 实现了最基本的登录功能，演示了SQL注入的现象
 * SQL注入的根本原因
 *      1. 用户提供的信息中含有SQL语句的关键字
 *      2. 这些用户提供的信息中的关键字参与了SQL语句的编译，导致SQL语句偏离了原意
 *
 * SQL注入是一种安全问题
 *
 * 如何避免
 *      java.sql.Statement 是存在SQL注入现象的
 *      它的原理是先拼接SQL字符串，然后在进行编译，所以他必然存在SQL注入的问题
 *
 *      JDBC API 为 Statement接口提供了一个子接口 java.sql.PreparedStatement 被称为预编译的数据库操作
 *      PreparedStatement可以解决SQL注入问题
 *      PreparedStatement可以对SQL语句进行预先编译，然后给编译好的SQL语句占位符传值
 *      用户即使提供了SQL语句关键字，但是这个关键字不再参与SQL语句的编译，因此解决了SQL注入的问题
 *
 */
public class Login {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String password = sc.nextLine();
        String realName = null;
        boolean login = false;

        try {
            conn = DbUtils.getConnection();
            // SQL注入：用户输入的信息中含有SQL语句关键字,和程序中的SQL语句进行字符串拼接，导致程序中的SQL语句改变了原意。
            // 导致SQL注入的最根本原因就是先进行了字符串拼接，然后在进行SQL语句的编译
            String sql = "select * from login where name = '" + name + "' and password = '" + password + "'";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                realName = rs.getString("realname");
                login = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(conn, stmt, rs);
        }
        System.out.println(login ? "欢迎您！" + realName : "登录失败！");
    }
}