package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: FileWriterTest
 * @Date: 2024/11/22 17:00
 */
public class FileWriterTest {
    /**
     * 注意其构造函数
     * FileWriter(String fileName, Charset charset, boolean append);
     * charset和append可以为null
     */
    @Test
    public void test1() {
        try (FileWriter writer = new FileWriter("D:\\study\\draft\\file3.txt")) {
            writer.write("hello world");
            writer.write("阿阿斯顿斯顿", 2, 2);
            writer.write("hello World".toCharArray());
            writer.write("阿斯顿撒旦".toCharArray(), 2, 2);

            writer.append("\n");
            writer.append("a");
            writer.append("b");
            writer.append("c");
            writer.append("d");


            // 手动刷新
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用文件字符输入输出流进行文件复制，凡是这种方式只能赋值普通文本文件
     */
    @Test
    public void test2() {
        try (FileReader reader = new FileReader("D:\\study\\draft\\file3.txt");
             FileWriter writer = new FileWriter("D:\\study\\draft\\file4.txt", true)) {

            char[] chars = new char[2048];
            int readCount = 0;
            while ((readCount = reader.read(chars)) != -1) {
                writer.write(chars, 0, readCount);
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 文件路径
     * 绝对路径：
     *      D:\study\draft\file4.txt
     *      FileReader reader = new FileReader("D:\\study\\draft\\file3.txt");
     * 相对路径：
     *      相对路径是相对于当前路径而言的，因而一定要搞清楚当前路径
     *      在idea中，默认的当前路径是project的根目录
     *
     */
    @Test
    public void test3() throws FileNotFoundException {
//        try (FileInputStream reader = new FileInputStream("log")){
//            byte[] bytes = new byte[1024];
//            int readCount = 0;
//            while ((readCount = reader.read(bytes)) != -1) {
//                System.out.println(new String(bytes, 0, readCount));
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        // Thread.currentThread() 获取当前进程
        // getContextClassLoader() 获取当前线程的类加载器
        // getResource() 表示从类的根路径下获取资源
        String path = Thread.currentThread().getContextClassLoader().getResource("自动从类路径中加载资源").getPath();
        System.out.println(path);
    }
}
