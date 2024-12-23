package com.powernode.reflect;

import com.powernode.map.UserDemo;

import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * 模拟框架的部分代码
 * 通过读取属性配置文件，获取类信息、方法信息，然后通过反射调用方法
 *
 * @author 19599
 */
public class ReflectTest4 {
    public static void main(String[] args) throws Exception {
        ResourceBundle bundle = ResourceBundle.getBundle("com/powernode/reflect/config");
        String className = bundle.getString("className");
        String methodName = bundle.getString("methodName");
        String parameterType = bundle.getString("parameterType");
        String paramterValue = bundle.getString("paramterValue");

        // 通过反射机制调用
        // 创建对象
        Class<?> clazz = Class.forName(className);
        Constructor<?> defaultCon = clazz.getDeclaredConstructor();
        Object o = defaultCon.newInstance();

        // 获取方法
        String[] parameterTypes = parameterType.split(",");
        Class<?>[] classParamTypes = new Class[parameterTypes.length];
        for (int i = 0; i < classParamTypes.length; i++) {
            classParamTypes[i] = getClassForPrimitive(parameterTypes[i]);
        }
        Method method = clazz.getDeclaredMethod(methodName, classParamTypes);

        // 获取参数值
        String[] paramValues = paramterValue.split(",");
        Object[] params = new Object[paramValues.length];
        for (int i = 0; i < paramValues.length; i++) {
            if (classParamTypes[i] == String.class) {
                params[i] = paramValues[i];
            } else if (classParamTypes[i] == int.class) {
                params[i] = Integer.parseInt(paramValues[i]);
            }
        }

        Object invoke = method.invoke(o, params);
        System.out.println(invoke);


    }

    private static Class<?> getClassForPrimitive(String parameterType) throws ClassNotFoundException {
        return switch (parameterType) {
            case "int" -> int.class;
            case "boolean" -> boolean.class;
            case "char" -> char.class;
            case "byte" -> byte.class;
            case "short" -> short.class;
            case "long" -> long.class;
            case "float" -> float.class;
            case "double" -> double.class;
            default -> Class.forName(parameterType); // 返回包装类的Class对象
        };

    }
}
