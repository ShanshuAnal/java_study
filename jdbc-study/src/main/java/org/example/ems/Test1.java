package org.example.ems;

import org.example.DAO.EmployeeDAO;
import org.example.beans.Employee;
import org.example.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: 19599
 * @Date: 2025/1/9 20:56
 * <p>
 * 使用JDBC实现员工信息管理系统
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎使用EMS！");
            System.out.println("1. 新增员工");
            System.out.println("2. 删除员工");
            System.out.println("3. 修改员工");
            System.out.println("4. 查询员工列表");
            System.out.println("5. 查询员工个人");
            System.out.println("0. 退出");
            System.out.print("功能编号：");
            int no = sc.nextInt();

            if (1 == no) {
                // 新增员工
                System.out.print("新增员工信息");
                System.out.println("- - - - - - - - - - - - - - - - - - - -");

                System.out.print("姓名：");
                String name = sc.next();

                System.out.print("职务：");
                String job = sc.next();

                System.out.print("入职日期：");
                String hiredate = sc.next();

                System.out.print("薪水");
                double salary = sc.nextDouble();

                System.out.print("地址");
                String address = sc.next();
                doAdd(name, job, hiredate, salary, address);
            } else if (2 == no) {
                // 删除员工
                doList();
                System.out.print("输入删除的员工id：");
                long id = sc.nextLong();
                doDelete(id);
                System.out.println("删除后的信息为：");
                doList();
            } else if (3 == no) {
                // 修改员工
                doList();
                System.out.print("请输入要修改的员工id：");
                long id = sc.nextLong();
                doDetail(id);
                System.out.print("请输入员工姓名：");
                String name = sc.next();
                System.out.print("请输入员工职务：");
                String job = sc.next();
                System.out.print("请输入员工薪水：");
                double salary = sc.nextDouble();
                System.out.print("请输入员工入职日期：");
                String hiredate = sc.next();
                System.out.print("请输入员工地址：");
                String address = sc.next();

                doModify(id, name, job, salary, hiredate, address);

                System.out.println("修改后的用户信息如下");
                doList();
            } else if (4 == no) {
                // 查询员工列表
                doList();
            } else if (5 == no) {
                // 查询员工个人信息
                System.out.print("输入要查询的员工的id：");
                long id = sc.nextInt();
                System.out.println("id为 " + id + " 的员工信息如下");
                System.out.println("姓名\t职务\t薪水\t地址");
                System.out.println("- - - - - - - - - - - - - - - - - - - -");
                doDetail(id);
            } else if (0 == no) {
                // 退出
                System.out.println("see you~");
                System.exit(0);
            } else {
                System.out.println("输入有误，重新输入！");
            }

        }


    }

    private static void doDetail(long id) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee emp = employeeDAO.selectById(id);
        if (emp != null) {
            System.out.println("姓名：" + emp.getName() + " 职务：" + emp.getJob() + " 薪水：" + emp.getSalary() + " 地址：" + emp.getAddress());
        } else {
            System.out.println("id为 " + id + " 的员工不存在！");
        }
        System.out.println("--------------------------------");
    }

    private static void doList() {
        System.out.println("员工信息列表如下");
        System.out.println("ID" + "\t" + "姓名" + "\t" + "职务");
        System.out.println("- - - - - - - - - - - - - - - - - - - -");

        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> list = employeeDAO.selectAll();

        for (Employee employee : list) {
            System.out.println(employee.getId() + "\t" + employee.getName() + "\t" + employee.getJob());
        }
        System.out.println("--------------------------------");
    }

    private static void doModify(long id, String name, String job, double salary, String hiredate, String address) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee emp = new Employee(id, name, salary, job, hiredate, address);
        int i = employeeDAO.update(emp);
        if (i > 0) {
            System.out.println("id为" + id + "的员工信息修改成功");
        } else {
            System.out.println("修改失败！");
        }
        System.out.println("--------------------------------");
    }

    private static void doDelete(long id) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.deleteById(id);
        System.out.println("--------------------------------");
    }

    private static void doAdd(String name, String job, String hiredate, double salary, String address) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee emp = new Employee(name, salary, job, hiredate, address);
        int i = employeeDAO.insertEmployee(emp);
        if (i > 0) {
            System.out.println("新增员工[" + name + "]插入成功！");
        } else {
            System.out.println("插入失败");
        }
        System.out.println("--------------------------------");

    }
}
