package com.powernode.map;

import java.io.Serial;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Objects;

/**
 * @Author: RG
 * @Package: com.powernode.map
 * @name: UserDemo
 * @Date: 2024/11/19 17:24
 */
public class UserDemo implements Comparable<UserDemo>, Cloneable, Serializable {
    private String name;
    transient private int age;

    public int publicNum;

    // 固定序列号
    @Serial
    private static final long serialVersionUID = 3519824000808198503L;
    // ObjectOutputStream 没有，ObjectInputStream 有
    // transient关键字修饰的属性不会参与序列化
    transient private int numl;

    public UserDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UserDemo(String name, int age, int numl) {
        this.name = name;
        this.age = age;
        this.numl = numl;
    }

    public UserDemo() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDemo userDemo = (UserDemo) o;
        return age == userDemo.age && Objects.equals(name, userDemo.name);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "UserDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", num=" + numl+
                '}';
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(UserDemo o) {
        if (name == o.getName()) {
            return o.getAge() - age;
        }
        return age - o.getAge();
    }

    private int getString(String s) {
        setName(s);
        return age;
    }

    public boolean nameAndAge(String name, int age) {
        setName(name);
        setAge(age);
        return true;
    }

}
