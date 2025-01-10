package org.example.DAO;

import org.example.beans.Product;
import org.example.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 19599
 * @Date: 2025/1/10 18:26
 */
public class ProductDAO extends BaseDAO1{
    public int insertProduct(Product product) {
        String sql = "insert into t_product (name, price, create_time) values (?, ?, ?)";
        return executeUpdate(sql, product.getName(), product.getPrice(), product.getCreateTime());
    }

    public int deleteById(long id) {
        String sql = "delete from t_product where id = ?";
        return executeUpdate(sql, id);
    }

    public int updateProduct(Product product) {
        String sql = "update t_product set name=?, price=?, create_time=? where id=?";
        return executeUpdate(sql, product.getName(), product.getPrice(), product.getCreateTime(), product.getId());
    }

    public Product selectById(long id) {
        String sql = "select name, price, create_time as createTime from t_product where id = ?";
        List<Product> list = executeQuery(sql, Product.class, id);
        if (list != null && !list.isEmpty()) {
            return list.getFirst();
        }
        return null;
    }

    public List<Product> selectAll() {
        String sql = "select id, name, price, create_time as createTime from t_product";
        return executeQuery(sql, Product.class);
    }
}

















