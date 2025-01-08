package org.example.test1;

import java.lang.reflect.Constructor;
import java.util.ResourceBundle;

/**
 * @Author: 19599
 * @Date: 2025/1/8 18:15
 */
public class JavaProgrammer {
    public static void main(String[] args) throws Exception {
        // 读取jdbc.properties文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driverName = bundle.getString("driver");

        // 通过反射创建对象
        Class<?> clazz = Class.forName(driverName);
        Constructor<?> constructor = clazz.getDeclaredConstructor();

        JDBC driver = (JDBC)constructor.newInstance();
        driver.connect();
    }
}
