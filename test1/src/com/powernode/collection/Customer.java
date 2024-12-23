package com.powernode.collection;

/**
 * @param <E>
 * @Author: RG
 * <p>
 * <p>
 * 相当于说 E 是给实例变量、实例方法用的
 * <p>
 * 静态方法需要自己定义
 */
public class Customer<E> {

    public void shopping(E e) {
        System.out.println(e + "shopping...");
    }


    // 在静态方法上使用泛型之前，类型要提前定义好才能用
    // 在返回类型前面定义声明泛型类型
    public static <T> void shopping1(T type) {
        System.out.println(type + "static shopping...");
    }

    public static <F> void print(F[] fs) {
        for (F f : fs) {
            System.out.println(f);
        }
    }

}
