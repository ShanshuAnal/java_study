package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: DataInputStreamTest
 * @Date: 2024/11/26 15:42
 */
public class DataInputStreamTest {
    /**
     * DataInputStream 数据流 数据字节输入流
     * 专门用来读取DataOutStream流写入的文件
     * 读取的顺序要和写入的顺序一致，要不然无法恢复原样
     */
    @Test
    public void test1() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("../data"))){


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
