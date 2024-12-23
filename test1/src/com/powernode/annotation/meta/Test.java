package com.powernode.annotation.meta;

/**
 * @Author: 19599
 * @Date: 2024/12/1 17:06
 */
@MyAnnotation
public class Test {
    public static void main(String[] args) {
        Class<Test> testClass = Test.class;
        MyAnnotation annotation = testClass.getAnnotation(MyAnnotation.class);
        // @MyAnnotation 必须设置 @Retention(RetentionPolicy.RUNTIME) 才能存储在字节码文件中
        System.out.println(annotation);
    }
}
