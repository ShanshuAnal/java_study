package com.powernode.annotation.meta;

/**
 * @Author: 19599
 * @Date: 2024/12/1 17:20
 */
@RepeatableAnnotation
@MyAnnotation
public class Test2 {
    /**
     * num is 0
     */
    @RepeatableAnnotation
    @MyAnnotation
    private static int num = 0;
}
