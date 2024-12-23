package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: GZIPOutputStreamTest
 * @Date: 2024/11/27 19:52
 */
public class GZIPOutputStreamTest {
    /**
     * GZIPOutputStream 专门进行文件压缩的 生成的格式为： xxx.gz
     *
     */
    @Test
    public void test() throws IOException {
        FileInputStream in = new FileInputStream("D:\\study\\draft\\file1.txt");
        GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream("D:\\study\\draft\\file.gz"));

        // 开始压缩 一边读 一边写
        byte[] bytes = new byte[1024];
        int readCount = 0;
        while ((readCount = in.read(bytes)) != -1) {
            gos.write(bytes, 0, readCount);
        }


        // 最重要的一步，刷新并生成压缩文件
        gos.finish();
        gos.close();
    }
}
