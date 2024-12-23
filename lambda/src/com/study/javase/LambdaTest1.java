package com.study.javase;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author: 19599
 * @Date: 2024/12/3 13:40
 */
public class LambdaTest1 {
    @Test
    public void test1() {
        // TreeSet集合中的元素是可以自动排序的
        // 1. 让集合中的元素实现Comparable接口
        // 2. 给TreeSet的构造方法传递一个Comparator对象，可以新建一个 也可以用匿名内部类

        TreeSet<User> users = new TreeSet<>((o1, o2) -> (o1.getAge() - o2.getAge()));

        User user1 = new User(20);
        User user2 = new User(17);
        User user3 = new User(25);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        System.out.println(users);

    }

    /**
     * lambda 和 匿名内部类
     * 1. 所需类型不同
     * 匿名内部类可以是接口、抽象类、具体类
     * lambda表达式只能是接口
     * 2. 使用限制不同
     * 如果接口中有且只有一个抽象方法（即该接口被@FunctionalInterface标注），就可以用匿名内部类和lambda
     * 如果接口中有多个抽象方法，那只能用匿名内部类
     * 3. 实现原理不同
     * 匿名内部类在编译之后，会生成一个单独的.class字节码文件
     * Lambda表达式：编译之后，没有生成一个单独.class字节码文件
     */
    @Test
    public void test2() {
        // 1. 所需类型不同
        // 抽象类
        LambdaTest1.animalRun(new Animal() {
            @Override
            public void run() {
                System.out.println("run");
            }
        });

        // 2. 使用限制不同
        // 很好理解，lambda只能表示一种规则

        // 3. 实现原理不同

    }

    public static void animalRun(Animal a) {
        a.run();
    }

}

/**
 * 抽象类
 */
abstract class Animal {
    public abstract void run();
}




class User {
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(age);
    }

    public User(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
