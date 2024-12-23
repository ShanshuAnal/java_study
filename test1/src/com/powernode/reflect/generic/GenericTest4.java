package com.powernode.reflect.generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author: RG
 * 获取方法参数上的泛型
 */
public class GenericTest4 {
    public static void main(String[] args) {
        // 获取Class对象
        Class<Cat> catClass = Cat.class;
        // 获取所有方法
        Method[] methods = catClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println("name of method : " + method.getName());
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            for (Type type : genericParameterTypes) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (Type t : actualTypeArguments) {
                        System.out.println(t);
                    }
                }
            }
        }

    }
}
