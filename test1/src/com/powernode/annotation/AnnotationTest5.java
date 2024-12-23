package com.powernode.annotation;

/**
 * @Author: 19599
 * @Date: 2024/12/1 16:08
 * <p>
 * 使用自定义注解MyAnnotation
 */
public class AnnotationTest5 {

    /*注解使用语法规则
    * 如果注解定义中有属性且没有默认值，
    * 那么使用注解的时候一定要给属性赋值
    * */
    @MyAnnotation( password = "123456",
            deprecation = @Deprecated,
            names = {"1", "2"})
    public void connDB() {

    }

}
