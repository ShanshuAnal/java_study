package com.powernode.annotation.exerciseTest;

import com.powernode.annotation.exercise.Table;

/**
 * @Author: 19599
 * @Date: 2024/12/1 19:03
 */
public class Test {
    public static void main(String[] args) {
        // 扫描类路径中的所有文件，找所有结尾为.class的文件
        // 通过.class文件的路径，找到全限定类名
        String path = Thread.currentThread().getContextClassLoader().getResource(".").getPath();
        System.out.println(path);

    }
}
