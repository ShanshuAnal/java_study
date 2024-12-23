package com.powernode.reflect;

import java.lang.reflect.*;
import java.util.ResourceBundle;

/**
 * @Author: RG
 * @Package: com.powernode.reflect
 * @name: ReflectTest3
 * @Date: 2024/11/30 16:59
 * <p>
 * 反编译String中的所有属性和方法
 */
public class ReflectTest3 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 资源绑定器
        ResourceBundle bundle = ResourceBundle.getBundle("com/powernode/reflect/classInfo");
        String className = bundle.getString("className");

        // 获取String类
        Class<?> stringClass = Class.forName(className);

        // 直接获取
//        Class<String> stringClass = String.class;

        StringBuilder sb = new StringBuilder();

        // 获取类的修饰符
        sb.append(Modifier.toString(stringClass.getModifiers()));

        sb.append(" class ");

        // 类名
//        sb.append(stringClass.getSimpleName());
        sb.append(stringClass.getName());

        sb.append(" extends ");

        // 父类
        sb.append(stringClass.getSuperclass().getSimpleName());


        // 所有接口
        Class<?>[] interfaces = stringClass.getInterfaces();
        if (interfaces.length > 0) {
            sb.append(" implements ");
            for (Class<?> iface : interfaces) {
                sb.append(iface.getName() + ", ");
            }
            sb.delete(sb.length() - 2, sb.length());
        }

        // 方法体
        sb.append("{\n");

        // 所有字段
        Field[] fields = stringClass.getDeclaredFields();
        for (Field field : fields) {
            sb.append("\t").
                    append(Modifier.toString(field.getModifiers()))
                    .append(field.getType().getSimpleName())
                    .append(" ")
                    .append(field.getName())
                    .append(";\n");
        }

        // 所有构造方法
        Constructor<?>[] constructors = stringClass.getConstructors();
        for (Constructor constructor : constructors) {
            sb.append("\t").
                    append(constructor.getName()).
                    append("(");
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                sb.append(parameter.getType().getName())
                        .append(parameter.getName())
                        .append(", ");
            }
            if (parameters.length != 0) {
                sb.delete(sb.length() - 2, sb.length());
            }
            sb.append("){}\n");
        }

        // 所有方法
        Method[] methods = stringClass.getDeclaredMethods();
        for (Method method : methods) {
            // 修饰符
            sb.append("\t")
                    .append(Modifier.toString(method.getModifiers()))
                    .append(" ")
                    // 返回值类型
                    .append(method.getReturnType().getName())
                    .append(" ")
                    // 方法名
                    .append(method.getName())
                    .append(" ");

            // 参数类型 + 参数名
            Parameter[] parameters = method.getParameters();
            sb.append("(");
            for (Parameter parameter : parameters) {
                sb.append(parameter.getType().getName())
                        .append(" ")
                        .append(parameter.getName())
                        .append(", ");
            }
            if (parameters.length > 0) {
                sb.delete(sb.length() - 2, sb.length());
            }
            sb.append(") {\n\t}\n");
        }


        sb.append("}");

        // 输出
        System.out.println(sb);
    }
}
