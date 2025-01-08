package org.example.test4;

import org.example.utils.DbUtils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @Author: 19599
 * @Date: 2025/1/8 23:43
 */
public class Test2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet resultSet = null;
        try {
            // 2. 获取连接
            conn = DbUtils.getConnection();
            // 3. 获取数据库对象
            stat = conn.createStatement();
            // 4. 执行SQL
            String sql = "select * from t_product";
            resultSet = stat.executeQuery(sql);
            // 5. 处理查询结果集
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 获取列的数量
            int columnCount = metaData.getColumnCount();
            System.out.println(columnCount);
            // 遍历每一列
            for (int i = 1; i <= columnCount; i++) {
                // 获取列名
                String name = metaData.getColumnName(i);
                // 获取列数据类型
                String type = metaData.getColumnTypeName(i);
                // 获取列的长度
                int size = metaData.getColumnDisplaySize(i);
                System.out.println("name: " + name + ", type: " + type + ", size: " + size);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(conn, stat, resultSet);
        }
    }
}
