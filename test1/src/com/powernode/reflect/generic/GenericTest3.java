package com.powernode.reflect.generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author: RG
 * <p>
 * 获取属性上的泛型
 */
public class GenericTest3 {
    public static void main(String[] args) {
        // 先获取Class对象
        Class<Cat> catClass = Cat.class;

        // 获取属性
        Field[] declaredFields = catClass.getDeclaredFields();

           // 遍历每个字段
        for (Field field : declaredFields) {

            Type genericType = field.getGenericType();
            if (genericType instanceof ParameterizedType) {
                ParameterizedType type = (ParameterizedType) genericType;
                Type[] actualTypeArguments = type.getActualTypeArguments();
                for (Type t : actualTypeArguments) {
                    System.out.println(t);
                }
            }
        }
    }
}
