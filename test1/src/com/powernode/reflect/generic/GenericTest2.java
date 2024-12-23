package com.powernode.reflect.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 获取接口类上的泛型
 *
 * @author 19599
 */
public class GenericTest2 {
    public static void main(String[] args) {
        Class<Cat> catClass = Cat.class;
        // 因为可以实现多个接口，因此返回的是Type[]
        Type[] genericInterfaces = catClass.getGenericInterfaces();

        for (Type type : genericInterfaces) {
            if (type instanceof  ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (Type actualT : actualTypeArguments) {
                    System.out.println(actualT);
                }
            }
        }

    }
}
