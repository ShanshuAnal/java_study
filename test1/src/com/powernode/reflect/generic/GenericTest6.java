package com.powernode.reflect.generic;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author: RG
 * 获取构造方法上的泛型
 */
public class GenericTest6 {
    public static void main(String[] args) {
        Class<Cat> catClass = Cat.class;
        Constructor<?>[] constructors = catClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
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
