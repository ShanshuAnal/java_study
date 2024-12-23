package com.powernode.reflect.generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author: RG
 * 获取方法返回值泛型
 */
public class GenericTest5 {
    public static void main(String[] args) {
        // 获取Class对象
        Class<Cat> catClass = Cat.class;
        // 获取所有方法
        Method[] methods = catClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println("name of method : " + method.getName());
            Type genericReturnType = method.getGenericReturnType();
            if (genericReturnType instanceof ParameterizedType) {
                ParameterizedType returnType = (ParameterizedType) genericReturnType;
                Type[] actualTypeArguments = returnType.getActualTypeArguments();
                for (Type t : actualTypeArguments) {
                    System.out.println(t);
                }
            }
        }

    }
}
