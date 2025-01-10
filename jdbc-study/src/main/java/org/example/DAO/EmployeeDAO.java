package org.example.DAO;

import org.example.beans.Employee;
import org.example.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 19599
 * @Date: 2025/1/9 22:28
 * <p>
 * 完成员工表t_employee中数据的增删改查
 * <p>
 * 增删改查 CRUD
 * <p>
 * DAO不负责仍和业务逻辑的处理，只负责CRUD
 * DAO是javaEE的设计模式之一
 * DAO的方法名一般都以insert delete update select开头
 * <p>
 * 要实现的操作：增加、删除、修改、查一个、查所有
 */
public class EmployeeDAO extends BaseDAO{

    /**
     * 新增员工
     *
     * @param emp 员工数据
     * @return 1表示插入成功，返回其他值表示失败
     */
    public int insertEmployee(Employee emp) {
        /*Connection con = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            con = DbUtils.getConnection();
            String sql = "insert into t_employee(name, job, salary, hiredate, address) values(?,?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getJob());
            ps.setDouble(3, emp.getSalary());
            ps.setString(4, emp.getHiredate());
            ps.setString(5, emp.getAddress());

            i = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(con, ps, null);
        }
        return i;*/

        String sql = "insert into t_employee(name, job, salary, hiredate, address) values(?,?,?,?,?)";
        return executeUpdate(sql, emp.getName(), emp.getJob(), emp.getSalary(), emp.getHiredate(), emp.getAddress());
    }

    /**
     * 根据id删除员工信息
     *
     * @param id 员工id
     * @return 1表示删除成功，返回其他值表示失败
     */
    public int deleteById(Long id) {
        String sql = "delete from t_employee where id = ?";
        return executeUpdate(sql, id);
    }

    /**
     * 修改员工信息
     *
     * @param newEmp 新的员工信息（id不变）
     * @return 1表示修改成功，其他值表示失败
     */
    public int update(Employee newEmp) {
        String sql = "update t_employee set name = ?, job = ?, salary = ?, hiredate = ?, address = ? where id = ?";
        return executeUpdate(sql, newEmp.getName(), newEmp.getJob(), newEmp.getSalary(), newEmp.getHiredate(), newEmp.getAddress(), newEmp.getId());

    }

    /**
     * 根据id获取员工信息
     *
     * @param id 员工id
     * @return 员工信息
     */
    public Employee selectById(Long id) {
        /*Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Employee emp = null;
        try {
            con = DbUtils.getConnection();
            String sql = "select name, job, salary, hiredate, address from t_employee where id = ?";

            ps = con.prepareStatement(sql);
            ps.setLong(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                emp = new Employee();
                emp.setId(id);
                emp.setName(rs.getString("name"));
                emp.setJob(rs.getString("job"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setHiredate(rs.getString("hiredate"));
                emp.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return emp;*/

        String sql = "select name, job, salary, hiredate, address from t_employee where id = ?";
        return query(sql, Employee.class, id);
    }

    /**
     * 获取所有员工信息
     *
     * @return 员工列表
     */
    public List<Employee> selectAll() {
        /*List<Employee> list = new ArrayList<Employee>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DbUtils.getConnection();
            String sql = "select id, name, job, salary, hiredate, address from t_employee ";

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Employee emp = null;
                emp = new Employee();
                emp.setId(rs.getLong("id"));
                emp.setName(rs.getString("name"));
                emp.setJob(rs.getString("job"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setHiredate(rs.getString("hiredate"));
                emp.setAddress(rs.getString("address"));
                list.add(emp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return list;*/
        String sql = "select id, name, job, salary, hiredate, address from t_employee ";
        return executeQuery(sql, Employee.class);
    }


}
