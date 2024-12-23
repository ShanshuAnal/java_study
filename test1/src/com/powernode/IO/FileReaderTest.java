package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: FileReaderTest
 * @Date: 2024/11/22 17:00
 */
public class FileReaderTest {
    /**
     * FileReader
     * 文件字符输入流，以字符的形式读文件，一次至少读取一个完整的字符，适合文本文件
     * FileInputStream是文件字节输入流，以字节的方式进行读取，适合二进制文件，图片、视频等
     */
    @Test
    public void test1() {
        try (FileReader fileReader = new FileReader("D:\\study\\draft\\file2.txt")) {
            // 这里是以字符的形式了，一个字符占2个字节，一共1024个字节
            char[] chars = new char[2048];
            int readCount = 0;
            while ((readCount = fileReader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, readCount));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
