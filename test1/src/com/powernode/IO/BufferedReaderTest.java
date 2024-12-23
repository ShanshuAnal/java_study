package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: BufferedReaderTest
 * @Date: 2024/11/23 0:45
 */
public class BufferedReaderTest {

    /**
     * BufferedReader 带有缓冲区的字符输入流
     * <p>
     * String readLine(); 返回一行的字符串
     */
    @Test
    public void test() {
        BufferedReader br = null;
        try {
//            br = new BufferedReader(new InputStreamReader(new FileInputStream("../")));
            br = new BufferedReader(new FileReader("../file.txt"));

//            char[] chars = new char[1024];
//            int readCount = 0;
//            while ((readCount = br.read(chars)) != -1) {
//                System.out.println(new String(chars, 0, readCount));
//            }

            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * BufferedReader、BufferedInputStream 的两个方法
     *  1. mark()
     *      在当前的位置上打标记
     *  2. reset()
     *      回到上一次打标记的位置
     *  先调用mark，在调用reset，组合起来的作用是：对某段内容进行重复读取
     *
     */
    @Test
    public void test2() {
        try (BufferedReader br = new BufferedReader(new FileReader("../file.txt"))){
            System.out.println(br.read());
            System.out.println(br.read());
            br.mark(51);
            System.out.println(br.read());
            System.out.println("---------------");

            br.reset();
            System.out.println(br.read());
            System.out.println(br.read());
            br.mark(53);
            System.out.println(br.read());
            System.out.println("---------------");

            br.reset();
            System.out.println(br.read());
            System.out.println(br.read());
            System.out.println(br.read());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
