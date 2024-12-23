package com.powernode.collection;

/**
 * @Author: RG
 * @Package: com.powernode.collection
 * @name: MyClass
 * @Date: 2024/10/16 22:08
 */
public class MyClass<E> {

    E name;

    public MyClass() {
    }

    public MyClass(E name) {
        this.name = name;
    }

    public static <T> void test(T type) {
        System.out.println(type);
    }

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
