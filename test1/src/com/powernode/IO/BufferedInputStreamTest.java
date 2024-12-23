package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: BufferedInputStreamTest
 * @Date: 2024/11/22 20:04
 */
public class BufferedInputStreamTest {

    /**
     * 1. BufferedInputStream 和 FileInputStream 用法相同
     * 2. 不同点：BufferedInputStream是缓冲流（包装流/处理流），效率更高，自带缓冲区，并且自己维护这个缓冲区，
     * 读大文件用这个BufferedInputStream实际上就是内存中的一块较大的区域，用于临时存储要读入的数据，
     * 它是通过减少I/O次数来提高效率节省资源的
     * 3. BufferedInputStream 是对 FileInputStream进行了功能增强，新加了一个缓冲区
     * 4. 构造方法：
     * BufferedInputStream(InputStream in);
     */
    @Test
    public void test1() {
        BufferedInputStream bufferIn = null;
        try {
            // 创建节点流
            FileInputStream in = new FileInputStream("../file.txt");
            // 创建包装流
            bufferIn = new BufferedInputStream(in);

            // 用法和FileInputStream完全相同
            byte[] bytes = new byte[1024];
            int readCount = 0;
            while ((readCount = bufferIn.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, readCount));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 包装流以及节点流，只用关闭最外层的包装流即可，节点流不用管
            // bufferIn.close()方法里面有 in.close()
            if (bufferIn != null) {
                try {
                    bufferIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
