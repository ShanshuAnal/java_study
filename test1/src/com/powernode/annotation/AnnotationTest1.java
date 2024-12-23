package com.powernode.annotation;

/**
 * @Author: RG
 * <p>
 * JDK有内置注解：@Deprecated
 * 1. 被这个注解标注的元素已过时
 * 2. 这个注解是给编译器看的，编译器看到这个注解会有警告提示信息
 */
public class AnnotationTest1 {
    public static void main(String[] args) {
        MyClass1 myClass1 = new MyClass1();

        System.out.println(MyClass1.num);

        myClass1.test();

    }
}


@Deprecated
class MyClass1 implements Comparable<MyClass1> {

    @Deprecated(since = "8", forRemoval = true)
    public static int num = 1;

    @Deprecated
    public void test() {

    }

    @Override
    public int compareTo(MyClass1 o) {
        return 0;
    }
}
