package org.example.SqlInject;

import org.example.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Author: 19599
 * @Date: 2025/1/9 1:20
 *
 * PreparedStatement 原理：
 *      1. 先对SQL语句进行预先编译
 *      2. 给SQL语句中占位符传值
 *
 * 在使用预编译的数据库操作对象PreparedStatement时，需要先编写SQL语句，然后再获取PreparedStatement对象
 * 在编写的所有SQL语句中，所有 “值” 的位置都要占位符进行代替，占位符用 ?
 * 每一个 ? 代表一个值，是一个占位符
 *
 * 占位符的两边不能使用单引号和双引号
 * 必须给每个占位符传值
 *
 * 解决SQL注入的本质：
 *      先将带有占位符的SQL语句进行预先编译，然后给占位符传值，即使用户提供的信息中含有SQL语句关键字，
 *      但是这些关键字不会参与SQL语句的编译，自然不会扭曲SQL语句的原意
 *
 *
 * PreparedStatement(子接口)和Statement(父接口)都是用于执行SQL语句的接口，它们的主要区别在于
 *      1. PreparedStatement预编译SQL语句，Statement直接提交SQL语句；
 *      2. PreparedStatement执行速度更快，可以避免SQL注入攻击；
 *              (PreparedStatement对于同一条SQL语句来说，编译一次，执行N次。
 *              而Statement是每次都要进行编译的。因此PreparedStatement效率略微高一些。)
 *      3. PreparedStatement会做类型检查，是类型安全的；
 *
 */
public class LoginPSTMT {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String password = sc.nextLine();
        String realName = null;
        boolean login = false;

        try {
            // 获取连接
            conn = DbUtils.getConnection();

//            String sql = "select * from login where name = '" + name + "' and password = '" + password + "'";
            String sql = "select realname from t_user where name = ? and password = ?";

            // 获取预先编译的数据库操作对象
            // psmt = conn.createStatement();
            pstmt = conn.prepareStatement(sql);

            // 给占位符传递值
            // 在JDBC中，所有下标从1开始
            pstmt.setString(1, name);
            pstmt.setString(2, password);

            // 执行SQL语句
            // rs = stmt.execute(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                realName = rs.getString("realname");
                login = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(conn, pstmt, rs);
        }
        System.out.println(login ? "欢迎您！" + realName : "登录失败！");
    }
}
