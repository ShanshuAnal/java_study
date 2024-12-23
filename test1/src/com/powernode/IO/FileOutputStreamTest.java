package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: FileOutputStreamTest
 * @Date: 2024/11/22 15:52
 */
public class FileOutputStreamTest {

    /**
     * FileOutputStream
     * 字节输出流，负责写
     * 常用构造方法
     * (1) FileOutputStream(String name)
     * 创建一个文件字节输出流对象，这个流在使用的时候，会将原文件内容全部清空，然后再开始写
     * (2) FileOutputStream(String name, boolean append)
     * 创建一个文件字节输出流对象，当qppend为true的时候，不会清空原文件内容，在原文件末尾写入
     * 创建一个文件字节输出流对象，当qppend为false的时候，会清空原文件内容，然后在开始写操作
     * 常用方法
     * (1) void close();
     * (2) void flush();
     * (3) void write(int b); 写一个字节
     * (4) void write(byte[] b); 将整个byte字节数组写出
     * (5) void write(byte[] b, int offset, int len); 将byte字节数组的一部分写出
     */
    @Test
    public void test1() {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("D:\\study\\draft\\file2.txt", false);
            byte[] bytes = {97, 98, 99, 100};
            // 写操作
            out.write(bytes);
            out.write(bytes, 0, 2);

            out.write(bytes, 2, 2);

            byte[] bytes1 = "WCNM".getBytes();
            out.write(bytes1);

            // 刷新
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("D:\\study\\draft\\file1.txt");
            out = new FileOutputStream("D:\\study\\draft\\file2.txt", true);

            /*int available = in.available();
            byte[] inBytes = new byte[available];
            in.read(inBytes);
            out.write(inBytes);*/

            byte[] inBytes = new byte[1024];
            int read = 0;
            while ((read = in.read(inBytes)) != -1) {
                out.write(inBytes, 0, read);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * try-with-resources 资源自动关闭 （Java7新特性）
     * 凡是实现了 AutoCloseable接口的流都可以使用,所有流
     * 语法格式：
     *      try(
     *          声明流；
     *          声明流；
     *          声明流；
     *      ){
     *
     *      } catch(Exception e){
     *          throw new ......;
     *      }
     */
    @Test
    public void test4() {
        try(FileInputStream in = new FileInputStream("D:\\study\\draft\\file1.txt")) {
            byte[] bytes = new byte[1024];
            int readCount = in.read(bytes);
            System.out.println(new String(bytes, 0, readCount));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
