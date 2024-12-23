package com.powernode.annotation.meta;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author: 19599
 * @Date: 2024/12/1 18:31
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatableAnnotations {
    RepeatableAnnotation[] value();
}
