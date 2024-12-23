package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: InputStreamReaderTest
 * @Date: 2024/11/25 20:33
 */
public class InputStreamReaderTest {
    /**
     * 使用InputStreamReader，可以指定解码的字符集，用来解决读过程中的乱码问题
     * InputStreamReader 是一个字符流，是一个转换流，是输入（从外存到内存）/编码（从字符到二进制数据）的过程.
     *
     * 常用构造方法：
     *      1. InputStreamReader(InputStream in); InputStream为字节流
     *      2. InputStreamReader(InputStream in, String charset); charset为编码格式
     *
     */
    @Test
    public void test1() {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("../file2.txt"), "GBK")){
            int readCount = 0;
            char[] chars = new char[1024];
            while ((readCount = isr.read(chars)) != -1) {
                System.out.println(new String(chars, 0, readCount));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 为了简化代码，我们直接用FileReader
     */
    @Test
    public void test2() {
        try (FileReader reader = new FileReader("../file.txt", Charset.forName("GBK"))){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
