package org.example.DAO;

import org.example.utils.DbUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

/**
 * @Author: 19599
 * @Date: 2025/1/9 23:21
 *
 * 最基础的DAO，所有的DAO继承该BaseDAO
 */
public class BaseDAO {

    /**
     * DML语句的通用更新方法
     * @param sql sql语句
     * @param params 可变长参数列表
     * @return 1为成功，其他为失败
     */
    public int executeUpdate(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int res = 0;
        try {
            // 获取连接
            conn = DbUtils.getConnection();

            // 获取数据库操作对象
            pstmt = conn.prepareStatement(sql);

            // 给占位符 ? 赋值
            if (params != null && params.length > 0) {
                // 有占位符 ?
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            // 执行sql语句
            res = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(conn, pstmt, null);
        }
        return res;
    }

    /**
     * DQL语句的通用查询方法
     * @param sql sql语句
     * @param clazz 对象类型
     * @param params 可变长参数列表，用于给占位符 ? 赋值
     * @return 返回一个对象集合
     * @param <T> 对象泛型
     */
    public <T> List<T> executeQuery(String sql, Class<T> clazz, Object... params) {
        List<T> res = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 获取链接
            conn = DbUtils.getConnection();

            // 获取预编译的数据库操作对象
            pstmt = conn.prepareStatement(sql);

            // 给占位符 ？ 赋值
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            // 执行SQL语句
            rs = pstmt.executeQuery();

            // 获取查询结果集的元数据
            ResultSetMetaData metaData = rs.getMetaData();
            // 获取列数
            int columnCount = metaData.getColumnCount();


            // 处理查询结果集
            while (rs.next()) {
                // 封装bean对象
                Constructor<T> constructor = clazz.getDeclaredConstructor();
                T obj = constructor.newInstance();

                // 给bean对象属性赋值
                // 假设表t_user 有两个字段 user_id, user_name
                // javabean中的User类，属性名 userId, userName
                // 执行语句 select user_id as userId , user_name as userName from t_user
                // 那么只要能获取列名，就能获取相应的数据，想到元数据集
                for (int i = 1; i <= columnCount; i++) {

                    // 这个列名是我们在sql语句中起的别名，就是javabean中的属性名
                    String fieldName = metaData.getColumnLabel(i);

                    // 通过反射机制获取到该属性Field对象
                    Field declaredField = clazz.getDeclaredField(fieldName);
                    // 打破封装
                    declaredField.setAccessible(true);
                    // 给属性赋值
                    declaredField.set(obj, rs.getObject(i));
                }

                // 将对象加入到List结合中
                res.add(obj);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 资源释放
            DbUtils.close(conn, pstmt, rs);
        }
        return res;
    }

    /**
     * 查询单个对象
     * @param sql sql语句
     * @param clazz 类的class属性
     * @param params 可变长参数列表
     * @return 返回查询到的对象
     * @param <T> 对象类型
     */
    public <T> T query(String sql, Class<T> clazz, Object... params) {
        List<T> list = executeQuery(sql, clazz, params);
        if (list != null && !list.isEmpty()) {
            return list.getFirst();
        }
        return null;
    }
}
