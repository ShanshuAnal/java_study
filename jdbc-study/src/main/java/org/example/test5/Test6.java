package org.example.test5;

import org.example.utils.DbUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: 19599
 * @Date: 2025/1/9 2:45
 * <p>
 * blob数据的插入和读取
 * 向数据库表中插入一张图片
 */
public class Test6 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        FileInputStream in = null;

        try {
            con = DbUtils.getConnection();
            String sql = "insert into t_img(name, img) values(?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, "ee");

            in = new FileInputStream("D:\\Software\\JetBrains\\IdeaProjects\\demo1\\jdbc-study\\src\\main\\java\\org\\example\\test5\\1.jpg");

            ps.setBlob(2, in);

            ps.executeUpdate();

        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(con, ps, null);
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
