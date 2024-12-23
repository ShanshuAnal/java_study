package com.powernode.thread;

import java.util.Objects;

/**
 * @Author: 19599
 * @Date: 2024/12/7 17:27
 */
public class UserTest implements Cloneable{
    private String name;
    private int age;

    public UserTest() {
    }

    public UserTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserTest userTest = (UserTest) o;
        return age == userTest.age && Objects.equals(name, userTest.name);
    }

    @Override
    protected UserTest clone() throws CloneNotSupportedException {

        return (UserTest) super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
