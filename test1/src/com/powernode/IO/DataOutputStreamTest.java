package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: DataOutputStreamTest
 * @Date: 2024/11/26 15:44
 */
public class DataOutputStreamTest {
    /**
     * DataOutputStream 数据字节输出流
     * 将java程序中的数据直接写入到文件中，写到文件中就是二进制
     * DataOutputStream写的效率很高，因为写的过程不需要转码
     * DataOutputStream写到文件中的数据，只能由DataInputStream读取
     */
    @Test
    public void test1() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("../data"))) {
            dos.write("asdasdasdasdasd".getBytes());
            dos.writeBoolean(true);
            dos.writeChar('c');
            dos.writeFloat(1.2F);
            dos.writeDouble(1.232323);
            dos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
