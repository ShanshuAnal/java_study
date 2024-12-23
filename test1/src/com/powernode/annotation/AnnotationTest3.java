package com.powernode.annotation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 19599
 * @Date: 2024/12/1 15:35
 *
 * <B>@SuppressWanings()</B> 抑制警告的注释
 * 常用属性值
 *      rwatypes:抑制未使用泛型的警告
 *      resource:抑制未关闭资源的警告
 *      deprecation:抑制使用了已过时的警告
 */
public class AnnotationTest3 {
    public static void main(String[] args) throws FileNotFoundException {

        @SuppressWarnings("rawtypes")
        List list = new ArrayList();

        @SuppressWarnings("resourse")
        FileOutputStream fileOutputStream = new FileOutputStream("");

        @SuppressWarnings("deprecation")
        MyClass1 myClass1 = new MyClass1();

    }
}
