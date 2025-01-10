package org.example.DAO;

import org.example.beans.Product;
import org.example.utils.DbUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 19599
 * @Date: 2025/1/10 18:44
 */
public class BaseDAO1 {
    public int executeUpdate(String sql, Object... params) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int res = 0;
        try {
            con = DbUtils.getConnection();
            pstmt = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            res = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(con, pstmt, null);
        }
        return res;
    }

    public <T> List<T> executeQuery(String sql, Class<T> clazz, Object... params) {
        List<T> list = new ArrayList<T>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DbUtils.getConnection();
            pstmt = con.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                Constructor<T> constructor = clazz.getDeclaredConstructor();
                T t = constructor.newInstance();

                for (int i = 0; i < columnCount; i++) {
                    // 获取属性名
                    String fieldName = metaData.getColumnLabel(i + 1);
                    // 获取属性值
                    Object obj = rs.getObject(fieldName);
                    // 获取字段属性
                    Field field = clazz.getDeclaredField(fieldName);
                    // 设置字段权限
                    field.setAccessible(true);
                    // 使用反射机制对属性赋值
                    field.set(t, obj);
                }
                // 至此一个T类型对象的字段已赋值完毕，加入集合即可
                list.add(t);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(con, pstmt, rs);
        }
        return list;
    }
}
