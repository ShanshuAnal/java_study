package com.powernode.annotation.meta;

import java.lang.annotation.Annotation;

/**
 * @Author: 19599
 * @Date: 2024/12/1 18:32
 * <p>
 * 反射注解
 */
public class Test3 {
    public static void main(String[] args) {
        Class<Test2> test2Class = Test2.class;
        Annotation[] annotations = test2Class.getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        if (test2Class.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = test2Class.getAnnotation(MyAnnotation.class);
            System.out.println(annotation);
        }

        if (test2Class.isAnnotationPresent(RepeatableAnnotation.class)) {
            RepeatableAnnotation annotation = test2Class.getAnnotation(RepeatableAnnotation.class);
            System.out.println(annotation.age());
            System.out.println(annotation.name());
        }
    }
}
