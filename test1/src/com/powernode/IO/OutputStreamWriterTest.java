package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: OutputStreamWriterTest
 * @Date: 2024/11/26 15:31
 */
public class OutputStreamWriterTest {
    /**
     * OutputStreamWriter 是一个字符流，也是一个转换流
     * OutputStreamWriter 是一个编码的过程，将字符转换为二进制编码
     * 在编码过程中如果出现字符集不一致的情况，就会出现乱码
     *
     * FileWriter 是 OutputStreamWriter 的子类，简化了JAVA代码
     */
    @Test
    public void test1() {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("../file2.txt", true), "GBK")){
            osw.write("asdasd\n");
            osw.write("asdasd阿松大".toCharArray());
            osw.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2() {
        try (FileWriter writer = new FileWriter("../file2.txt", Charset.forName("GBK"))){
            writer.write("aas阿三大苏打实打实2");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
