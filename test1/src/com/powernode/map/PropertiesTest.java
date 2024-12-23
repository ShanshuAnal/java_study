package com.powernode.map;

import org.junit.jupiter.api.Test;

import java.util.Enumeration;
import java.util.Properties;

/**
 * @Author: RG
 * @Package: com.powernode.map
 * @name: PropertiesTest
 * @Date: 2024/11/21 15:02
 */
public class PropertiesTest {

    /**
     * Properties 属性类 继承HashTable，线程安全，是一个Map集合
     * 一般和属性配置文件联合使用
     */
    @Test
    public void test() {
        Properties pro = new Properties();

        pro.setProperty("username", "root");
        pro.setProperty("password", "123456");

        System.out.println(pro.getProperty("username"));
        System.out.println(pro.getProperty("password"));

        Enumeration<?> names = pro.propertyNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            String property = pro.getProperty(name);
            System.out.println(name + "=" + property);
        }


    }
}
