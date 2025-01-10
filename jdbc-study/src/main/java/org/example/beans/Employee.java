package org.example.beans;

import java.util.Objects;

/**
 * @Author: 19599
 * @Date: 2025/1/9 22:24
 *
 * 员工类
 * 专门用于数据封装，封装了员工信息
 * 这个类被称为pojo类或者bean，也就是普通的java类
 */
public class Employee {
    private Long id;
    private String name;
    private Double salary;
    private String job;
    private String hiredate;
    private String address;

    public Employee() {
    }

    public Employee(Long id, String name, Double salary, String job, String hiredate, String address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.job = job;
        this.hiredate = hiredate;
        this.address = address;
    }

    public Employee(String name, Double salary, String job, String hiredate, String address) {
        this.name = name;
        this.salary = salary;
        this.job = job;
        this.hiredate = hiredate;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary) && Objects.equals(job, employee.job) && Objects.equals(hiredate, employee.hiredate) && Objects.equals(address, employee.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, job, hiredate, address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", job='" + job + '\'' +
                ", hiredate='" + hiredate + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
