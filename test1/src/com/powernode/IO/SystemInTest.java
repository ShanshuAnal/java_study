package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: SystemInTest
 * @Date: 2024/11/27 13:05
 */
public class SystemInTest {
    /**
     * System.in 获取到一个InputStream 就是一个标准输入流
     * 标准输入流用来接收用户在控制台上的输入；普通的输入流是接受文件或者网络中的数据（数据源不同）
     * 不需要关闭（它是一个系统级的全局的流，JVM负责最后的关闭）
     */
    public static void main(String[] args) throws IOException {
        // 修改数据源
//        System.setIn(new FileInputStream("../file1.txt"));


        // 获取标准输入流对象（不是new一个了）
        InputStream in = System.in;

        int readCount = 0;
        byte[] bytes = new byte[1024];

        readCount = in.read(bytes);
        // 如果在命令行输出“asd”，字符串的长度是3，但是readCount = 4，因为末尾有一个换行符'/n'
        for (int i = 0; i < readCount; i++) {
            System.out.println(bytes[i]);
        }

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void test1() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
