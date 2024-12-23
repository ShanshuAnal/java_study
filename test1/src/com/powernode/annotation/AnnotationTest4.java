package com.powernode.annotation;

/**
 * @Author: 19599
 * @Date: 2024/12/1 16:02
 *
 * <b>@FunctionalInterface</b>
 * 1. 专门用来标注接口的
 * 2. 被标注的接口必须是一个函数式接口，否则就会报错
 * 3. 给编译器看的
 * 4. 如果这个接口中，有且只有一个抽象方法(默认、静态方法不算在内)，就是函数式接口
 *
 */
public class AnnotationTest4 {
    public static void main(String[] args) {

    }
}

@FunctionalInterface
interface Flyable {

    void fly();

    default void run() {
        System.out.println("default可以");
    }

    static void doSome() {
        System.out.println("static可以");
    }

}
