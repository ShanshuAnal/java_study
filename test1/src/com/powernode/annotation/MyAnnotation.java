package com.powernode.annotation;

/**
 * @Author: 19599
 * @Date: 2024/12/1 16:12
 *
 * <h2>自定义注解</h2>
 * 定义结构 + 属性
 *
 * 定义属性要在属性后面加()
 * 属性类型 属性名()
 *
 * 属性的类型有要求
 * 1. byte short int long float double boolean char
 * 2. Class Enum String 注解
 * 3. 以上类型的一维数组
 *
 * 使用事项：
 * 1. 如果属性只有一个，并且属性名为value，那么使用注解时，value可以省略不写
 *  比如 @Table("zhang")
 * 2. 如果属性类型是一维数组的话，使用注解时，数组值只有一个，数组的大括号可以省略
 *
 */
public @interface MyAnnotation {
    String driver() default "com.mysql.cj.jdbc.Driver";

    String url() default "jdbc:mysql://localhost:8080/powernode";

    String user() default "root";

    String password() default "zhang914";

//    Class clazz();

//    Enum enum();

    Deprecated deprecation();

    String[] names();



}
