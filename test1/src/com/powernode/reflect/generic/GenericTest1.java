package com.powernode.reflect.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 获取父类的泛型信息
 * @author 19599
 */
public class GenericTest1 {
    public static void main(String[] args) {
        // 获取类
        Class<Cat> catClass = Cat.class;

        // 只有Type对象，不是数组，因为java只能单继承
        // 如果是获取接口的泛型信息，那么是type[],因为可以实现多个接口
        Type type = catClass.getGenericSuperclass();
        System.out.println(type);
//
//        System.out.println(type instanceof Class<?>);
//        System.out.println(type instanceof ParameterizedType);

        // 如果父类使用了泛型
        if (type instanceof ParameterizedType) {
            // 转换为参数化类型
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type a : actualTypeArguments) {
                System.out.println(a);
            }
        }
    }
}



