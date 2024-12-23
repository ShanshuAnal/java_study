package com.powernode.annotation.exercise;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: 19599
 * @Date: 2024/12/1 18:56
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    /**
     * 字段名
     * @return
     */
    String name();

    /**
     * 字段类型
     * @return
     */
    String type() default "varchar";
}
