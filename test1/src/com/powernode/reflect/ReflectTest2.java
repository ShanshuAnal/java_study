package com.powernode.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

/**
 * 读取属性配置文件，获取类名，通过反射机制实例化对象
 * 通过这个例子就知道反射机制是灵活的，这个程序就可以做到对象的动态创建
 * 只要修改属性配置文件classInfo.properties就可以完成不同的对象实例化
 *
 * @author 19599
 */
public class ReflectTest2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 资源绑定器
        ResourceBundle bundle = ResourceBundle.getBundle("com.powernode.reflect.classInfo");

        // 通过key获取value
        String className = bundle.getString("className");

        // 通过反射实例化对象
        Class<?> class1 = Class.forName(className);
        Constructor<?> constructor = class1.getConstructor();
        Object o = constructor.newInstance();
        System.out.println(o);

    }
}
