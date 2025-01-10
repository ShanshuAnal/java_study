package org.example.test5;

import org.example.utils.DbUtils;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

/**
 * @Author: 19599
 * @Date: 2025/1/9 18:35
 *
 * 使用PreparedStatement将表中的图片查询出来
 * 将图片从数据库中读取到本地硬盘
 */
public class Test7 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream in = null;
        OutputStream out = null;

        try {
            // 1. 注册驱动
            // 2. 获取连接
            conn = DbUtils.getConnection();
            String sql = "select id, img from t_img where name = ?";

            // 3. 获取数据库对象
            ps = conn.prepareStatement(sql);

            // 4. 执行sql语句
            ps.setString(1, "ee");
            rs = ps.executeQuery();

            // 5. 结果集处理
            if (rs.next()) {
                // 图片就在结果集对象中
                // 我们要从数据库中读取图片到内存中，所以是输入流
                in = rs.getBinaryStream("img");

                // 搞一个输出流，用于将内存中的图片存入硬盘中
                out = new FileOutputStream("jdbc-study/src/main/java/org/example/test5/11.jpg");

                byte[] bytes = new byte[1024];
                int readCount = 0;
                while ((readCount = in.read(bytes))!= -1) {
                    out.write(bytes, 0, readCount);
                }
            }

            if (out != null) {
                out.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 资源释放
            DbUtils.close(conn, ps, rs);

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
