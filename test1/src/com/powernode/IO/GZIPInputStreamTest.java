package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.zip.GZIPInputStream;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: GZIPInputStream
 * @Date: 2024/11/27 19:59
 */
public class GZIPInputStreamTest {

    /**
     * GZIPInputStream负责解压缩的  加压缩的文件拓展名为 xx.gz
     */
    @Test
    public void test1() throws IOException {
        GZIPInputStream gZipIn = new GZIPInputStream(new FileInputStream("D:\\study\\draft\\file.gz"));
        FileOutputStream out = new FileOutputStream("D:\\study\\draft\\file.txt");
        byte[] bytes = new byte[1024];
        int readCount = 0;
        while ((readCount = gZipIn.read(bytes)) != -1) {
            out.write(bytes, 0, readCount);
        }

        out.flush();
        out.close();
        gZipIn.close();
    }
}
