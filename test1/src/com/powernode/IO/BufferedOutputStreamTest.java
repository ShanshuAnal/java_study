package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: BufferedOutputStreamTest
 * @Date: 2024/11/22 20:43
 */
public class BufferedOutputStreamTest {

    /**
     * BufferedOutputStream 缓冲流 输出流
     * 创建方式和BufferedInputStream一样
     * BufferedOutputStream 是包装流 ； FileOutputStream是结点流
     */
    @Test
    public void test() {
        BufferedOutputStream bufferedOut = null;
        try {
            FileOutputStream out = new FileOutputStream("../file.txt");
            bufferedOut = new BufferedOutputStream(out);
            bufferedOut.write("asdasd".getBytes());

            bufferedOut.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedOut != null) {
                try {
                    bufferedOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 用 BufferedOutputStream 和 BufferedInputStream 完成文件的复制
     */
    @Test
    public void test2() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("../file.txt"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("../file1.txt"))) {

            byte[] bytes = new byte[1024];
            int readNum = 0;
            while ((readNum = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, readNum);
            }

            bos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void v() {
//    FileInputStream
//    FileOutputStream

//    FileReader
//    FileWriter

//    BufferedInputStream
//    BufferedOutputStream

//        Bu fferedReader
//        BufferedWriter

    }
}


