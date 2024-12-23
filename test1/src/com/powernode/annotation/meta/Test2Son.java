package com.powernode.annotation.meta;

import java.lang.annotation.Annotation;

/**
 * @Author: 19599
 * @Date: 2024/12/1 17:30
 */
public class Test2Son extends Test2{
    public static void main(String[] args) {
        // Test2使用了@MyAnnotation注解，@MyAnnotation注解有@Inherted注解
        // Test2Son继承了Test2，那么Test2Son也同样继承了@MyAnnotation注解
        Class<Test2Son> test2SonClass = Test2Son.class;
        Annotation[] annotations = test2SonClass.getAnnotations();
        for (Annotation annotation : annotations) {
            // 这边能输出是因为
            // @MyAnnotation 加了 @Retention(RetentionPolicy.RUNTIME)注解
            System.out.println(annotation);
        }
    }
}
