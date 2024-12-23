package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: PropertiesLoadTest
 * @Date: 2024/11/27 16:08
 */
public class PropertiesLoadTest {
    /**
     * 使用Porperties集合类+ IO流来读取属性配置文件
     * 将属性配置文件中的配置信息加载到内存中
     */
    @Test
    public void test1() throws IOException {
//        FileReader reader = new FileReader("src/jdbc.properties");
        //以src为根目录
        String path = Thread.currentThread().getContextClassLoader().getResource("jdbc.properties").getPath();
//        String path = Thread.currentThread().getContextClassLoader().getResource("com/powernode/IO/jdbc.properties").getPath();
        FileReader reader = new FileReader(path);


        Properties properties = new Properties();

        // 将jdbc.properties文件中的配置信息加载到properties对象中
        properties.load(reader);

        // 获取所有key
        Enumeration<?> names = properties.propertyNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            String value = properties.getProperty(name);
            System.out.println(name + "=" + value);
        }

        // 通过key来获取value
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        System.out.println(driver);
        System.out.println(url);
        System.out.println(user);
        System.out.println(password);


        // 关闭输入流
        reader.close();
    }

    /**
     * BundleProperties
     * 使用jdk中提供的资源绑定器来绑定配置文件
     */
    @Test
    public void test2() throws FileNotFoundException {
        // 以src为根目录
        ResourceBundle bundle = ResourceBundle.getBundle("com/powernode/IO/jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        System.out.println(driver);
        System.out.println(url);
        System.out.println(user);
        System.out.println(password);


    }








}
