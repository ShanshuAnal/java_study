package org.example.pms;

import org.example.DAO.EmployeeDAO;
import org.example.DAO.ProductDAO;
import org.example.beans.Employee;
import org.example.beans.Product;
import org.example.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: 19599
 * @Date: 2025/1/10 18:02
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 增加产品");
            System.out.println("2. 修改产品");
            System.out.println("3. 删除产品");
            System.out.println("4. 查询所有产品");
            System.out.println("5. 查询一个产品");
            System.out.println("0. 退出");

            System.out.print("输入：");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("输出添加的信息：");
                System.out.print("名称：");
                String name = sc.next();

                System.out.print("价钱：");
                double price = sc.nextDouble();

                System.out.print("生产日期：");
                String createTime = sc.next();

                doAdd(name, price, createTime);
            } else if (choice == 2) {
                doList();
                System.out.print("请输入修改产品的id：");
                long id = sc.nextLong();
                System.out.print("名称：");
                String name = sc.next();
                System.out.print("价钱：");
                double price = sc.nextDouble();
                System.out.print("生产日期：");
                String createTime = sc.next();
                doModfy(id, name, price, createTime);
            } else if (choice == 3) {
                System.out.print("请输入删除产品的id：");
                long id = sc.nextLong();
                doDelete(id);
            } else if (choice == 4) {
                System.out.println("所有产品信息如下：");
                doList();
            } else if (choice == 5) {
                System.out.print("请输入查询产品的id：");
                long id = sc.nextLong();
                doSearch(id);
            } else if (choice == 0) {
                System.out.println("see you~");
                System.exit(0);
            } else {
                System.out.println("illegal choice");
            }
            System.out.println("----------------------------------------");
        }
    }

    private static void doDelete(long id) {
        ProductDAO productDAO = new ProductDAO();
        int i = productDAO.deleteById(id);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    private static void doModfy(long id, String name, double price, String createTime) {
        Product product = new Product(id, name, price, createTime);
        ProductDAO productDAO = new ProductDAO();

        int i = productDAO.updateProduct(product);
        if (i > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    private static void doSearch(long id) {
        System.out.println("名称" + "\t" +"价钱" + "\t" +"生产日期");
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.selectById(id);
        if (product != null) {
            System.out.println(product.getName() + "\t" + product.getPrice() + "\t" + product.getCreateTime());
        } else {
            System.out.println("查找失败！");
        }
    }

    private static void doList() {
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.selectAll();
        if (!products.isEmpty()) {
            System.out.println("id" + "\t" + "名称" + "\t" +"价钱" + "\t" +"生产日期");
            for (Product product : products) {
                System.out.println(product.getId() + "\t" + product.getName() + "\t" + product.getPrice() + "\t" + product.getCreateTime());
            }
        } else {
            System.out.println("没有产品！");
        }
    }

    private static void doAdd(String name, double price, String createTime) {
        Product product = new Product(name, price, createTime);
        ProductDAO productDAO = new ProductDAO();
        int i = productDAO.insertProduct(product);
        if (i > 0) {
            System.out.println(name + "添加成功");
        } else {
            System.out.println("添加失败");
        }
    }
}


























