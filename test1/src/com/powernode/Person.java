package com.powernode;

/**
 * @Author: Ryan Gosling Literally me
 * @Package: com.powernode
 * @name: Person
 * @Date: 2024/9/21 17:50
 */
public class Person implements Comparable<Person>{
    int age;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(Person o) {
        return age - o.getAge();
    }
}
