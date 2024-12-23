package com.powernode;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @Author: RG
 * @Package: com.powernode
 * @name: testSystem
 * @Date: 2024/10/16 0:06
 */
public class testSystem {

    @Test
    public void testSystem() {
        System.out.println(12);

        PrintStream out = System.out;
        out.println(12);


        Scanner sc = new Scanner(System.in);
        InputStream inputStream = System.in;
        Scanner scanner = new Scanner(inputStream);
//        System.out.println(scanner.next());

        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        } catch (Exception e) {
            System.err.println("b != 0");
        }

        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());

        // 获取系统环境变量
        System.out.println(System.getenv());
        System.out.println(System.getenv().get("Path"));


        // 获取系统所有属性
        System.out.println(System.getProperties());
        System.out.println(System.getProperty("java.vm.name"));

    }
}
