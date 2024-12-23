package com.powernode.annotation.meta;

import java.lang.annotation.*;

/**
 * @Author: 19599
 * @Date: 2024/12/1 17:04
 * <h2>元注解</h2>
 * 给注解标注的直接叫做元注解
 *
 * 1. @Retention 他表示注解存在阶段是保留在源代码（编译期），字节码（类加载）或者运行阶段（JVM中运行）
 * (1) @Retention(RetentionPolicy.SOURCE)   仅存在源代码中，在字节码中不包含
 * (2) @Retention(RetentionPolicy.CLASS)    在字节码文件中存在，运行时无法获取（默认）
 * (3) @Retention(RetentionPolicy.RUNTIME)  在字节码文件中存在，运行时可通过反射获取
 *
 * 2. @Target 设置注解可以使用的位置，用ElementType枚举
 *
 * 3. @Documented 被标注的注解可以生成到帮助文档中
 *
 * 4. @Inherited 被标注的注解支持继承
 *
 * 5. @Repeatable 被标注的注解可以被重复使用
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface MyAnnotation {


}
